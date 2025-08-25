#!/bin/bash

########################
################# Defs
########################

NC='\033[0m' # No color
CYAN='\033[1;36m'
RED='\033[0;31m'
BGREEN='\033[1;32m' # Bold green

err() {
  echo -e ${RED}"[$(date +'%Y-%m-%dT%H:%M:%S%z')]: $*"${NC} >&2
}

chech_health() {
  if [ $(docker inspect -f '{{.State.Health.Status}}' $(docker compose ps -q $1)) == "healthy" ]; then
    echo -e ${BGREEN}"${1} is healthy"${NC}
  elif [[ $(docker inspect -f '{{.State.Health.Status}}' $(docker compose ps -q $1)) == "unhealthy" ]]; then
    err "${1} is unhealthy"
    err "run failed"
    exit 1
  else
    err "${1} is undetermined"
    err "run failed"
    exit 1
  fi
}

print_help_and_exit() {
  echo " "
  echo "------------------------------------------------------"
  echo "Check health of given services."
  echo ""
  echo "Options: "
  echo "-t int      start the script after int seconds <1-99>"
  echo ""
  echo "Example Usage:"
  echo "ch_health -t 20 backend frontend database"
  echo "ch_health backend "
  echo "------------------------------------------------------"
  echo " "
  exit 0
}

service_exists() {
  [ -n "$(docker compose ps -q $1)" ]
}

########################
################# Script
########################

if [[ $1 == "-h" || $1 == "--help" ]]; then
  print_help_and_exit
fi

timeout=''

while getopts 't:' flag; do
  case "${flag}" in
  t) timeout="${OPTARG}" && t_flag_used=1 ;;
  \?)
    err "illegal option or no argument provided, argument received: "${OPTARG}""
    exit 1
    ;;
  esac
done

if [[ $timeout =~ ^[1-9][0-9]{0,1}$ ]]; then
  echo "Sleeping for ${timeout}"
  sleep $timeout
  shift # if sleep specified, shift pass -t and time args
  shift
elif [[ -n "$timeout" ]]; then
  err "invalid -t (timeout) argument: $timeout, use -h or --help for example usage"
  exit 1
fi

for service_name in "$@"; do
  if service_exists $service_name; then
    chech_health $service_name
  else
    err "invalid service name: $service_name, use -h or --help for example usage"
    exit 1
  fi
done
