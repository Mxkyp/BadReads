<a id="readme-top"></a>
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
<!-- PROJECT LOGO -->
<br />
<div align="center">
    <img src="images/logo.png" height="250" width="auto" >

  <p align="center">
    <br />
    An open-source book recommendation site.
    <br />
    <br />
    <br />
    <a href="https://badreads.mpawlos.com/">View On the web</a>
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
        <li><a href="#Architecture">Architecture</a></li>
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

**BadReads** is a **self-hosted fullstack microservice** based book-recommendation app. \
<u>**GoodReads but better/Pinterest for books with better recommendations** (That's the plan).</u>


### Purpose
The purpose of this project is learning:
1. Kubernetes and Docker.
2. Self-hosting, administrator duties.
3. Developing great REST API's.
4. Web/System/container security.
5. Building fully functional web-services.
6. Infrastructure/IaC.
7. Making production grade SaaS products.
8. Scalable application architecture.

And provide a **easily reproducible, complete**  full-stack application. \
For others trying to learn how to build applications for the web.

### Architecture

<div align="center">
    <img src="images/archi.png" alt="Architecture" width="700" height="1100">
</div>

### Built With

 [![React][React.js]][React-url]
 ![NodeJS](https://img.shields.io/badge/node.js-6DA55F?style=for-the-badge&logo=node.js&logoColor=white)
[![Vite](https://img.shields.io/badge/Vite-646CFF?logo=vite&logoColor=fff)](#)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Nginx](https://img.shields.io/badge/nginx-%23009639.svg?style=for-the-badge&logo=nginx&logoColor=white)
![GitHub Actions](https://img.shields.io/badge/github%20actions-%232671E5.svg?style=for-the-badge&logo=githubactions&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)

## Getting Started

**Make sure ports 80 and 443 are free.**

Clone the repository:

  ```bash
     git clone https://github.com/Mxkyp/BadReads.git && cd BadReads
  ```

Run it:

  ```sh
      docker compose up 
  ```

You can now see the website at localhost

### Prerequisites

  - git 
  - docker
  
## Usage

The project is to be used for educational purposes. \
It's very early in development, but as it grows i will try to make it as pristine example of a fullstack app as i can. \
So newcomers can have a reference production ready-app as i think there are **not so many spring-based examples**.

## Roadmap

### General

* [ ] Add Changelog
* [ ] **General refactoring**
* [ ] Website logo and info

### infrastructure

* [ ] Proper secret handling (HashiCorpVault)
* [ ] Tests in pipeline
* [ ] Monitoring
* [ ] Limit resource usage
* [ ] Rollbacks, seamless delivery

### Backend

* [ ] Add Spring security, OAuth2
* [ ] Add user, comment services
* [ ] Add integration tests
* [ ] Consider adding lombok and migrating from maven to gradle

### Frontend

* [ ] Simple searchbar with logo
* [ ] Simplify the file structure

### Database

* [ ] external data storage ex. Google Cloud
* [ ] **find a better book data set**

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

Mikołaj Pawłoś - [Linkedin](www.linkedin.com/in/mikołaj-pawłoś-7a4715380)

[React.js]: https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB
[React-url]: https://reactjs.org/
