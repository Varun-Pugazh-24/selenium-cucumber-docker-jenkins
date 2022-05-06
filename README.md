# Selenium Cucumber Java Test Automation Framework with Jenkins, Docker and Zalenium

![image](https://img.shields.io/badge/Selenium-43B02A?style=for-the-badge&logo=Selenium&logoColor=white) ![Java Logo](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white) ![Java Logo](https://img.shields.io/badge/Jenkins-D24939?style=for-the-badge&logo=Jenkins&logoColor=white) ![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white) <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTNGzD6zl6UI_UgaKs0TSQDZ87beyKiZLQqGw&usqp=CAU" width="100" />





## To execute tests
-To run in local change cucumber.proprties file property to **run_tests_in=local**

-To run in zalenium docker first start zalenium(see below) and change cucumber.proprties file property to **run_tests_in=remote**

## Start Zalenium
```sh
docker run --rm -ti --name zalenium -p 4444:4444 -v /var/run/docker.sock:/var/run/docker.sock -v /tmp/videos:/home/seluser/videos --privileged dosel/zalenium start
```
## Stop Zalenium
```sh
docker stop zalenium
```