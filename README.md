<a id="readme-top"></a>
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
<!-- PROJECT LOGO -->
<br />
<div align="center">
    <img src="images/logo.png" alt="Logo" width="300" height="200">

  <h3 align="center">BadReads</h3>

  <p align="center">
    A Spring-built goodReads clone
    <br />
    <br />
    <br />
    <a href="https://github.com/Mxkyp/BadReads">View Demo</a>
    &middot;
    <a href="https://github.com/Mxkyp/BadReads/issues/new?labels=bug&template=bug-report---.md">Report Bug</a>
    &middot;
    <a href="https://github.com/Mxkyp/BadReads/issues/new?labels=enhancement&template=feature-request---.md">Request Feature</a>
  </p>
</div>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
        <li><a href="#Architecture">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->
## About The Project

The goal of this project was putting into practice my learning of Spring boot, containers, docker and infrastructure project delivery and simply having fun.

As of right now I've implemented

* *microservice based (cough cough)* infrastructure, separating the frontend, backend and database into separate entities using docker containers.
* **REST API** using spring, which handles HTTP GET requests returning appropriate status codes.
* Normalized locally deployed database with assosiative entities.
* A simple react + nodejs frontend. Generating pages based on given data.
* A github actions pipeline, building and deploying the app to my homelab, allowing me to preview it over LAN.

### Architecture

<div align="center">
    <img src="images/archi.png" alt="Architecture" width="700" height="1000">
</div>

### Built With

 [![React][React.js]][React-url]
 ![NodeJS](https://img.shields.io/badge/node.js-6DA55F?style=for-the-badge&logo=node.js&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Nginx](https://img.shields.io/badge/nginx-%23009639.svg?style=for-the-badge&logo=nginx&logoColor=white)
![GitHub Actions](https://img.shields.io/badge/github%20actions-%232671E5.svg?style=for-the-badge&logo=githubactions&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)

## Getting Started

Clone the repository:

  ```sh
     git clone https://github.com/Mxkyp/BadReads.git
     cd BadReads
  ```

Build all the required images:

  ```sh
      chmod +x buildImages.sh 
      ./buildImages.sh
  ```

Run it:

  ```sh
      docker compose up 
  ```

You can now see the website at localhost:3000

### Prerequisites

  Basically git and docker.
  
## Usage

The project is to be used for educational purposes. \
It's very early in development, but as it grows i will try to make it as pristine example of a fullstack app as i can. \
So newcomers can have a reference production ready-app as i think there are **not so many spring-based examples**.

## Roadmap

### General

* [ ] Add Changelog
* [ ] **General refactoring**

### infrastructure

* [ ] Proper secret handling

### Backend

* [ ] Add Spring security, OAuth2
* [ ] Add user, comment services
* [ ] Add integration tests

### Frontend

* [ ] goodReads 1:1 but better

### Database

* [ ] external data storage ex. Google Cloud

See the [open issues](https://github.com/Mxkyp/BadReads/issues) for a full list of proposed features (and known issues).

## Contributing

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- CONTACT -->
## Contact

Your Name - [@your_twitter](https://twitter.com/your_username) - <email@example.com>

Project Link: [https://github.com/your_username/repo_name](https://github.com/your_username/repo_name)

[React.js]: https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB
[React-url]: https://reactjs.org/
