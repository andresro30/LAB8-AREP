FROM openjdk:8

WORKDIR /usrapp/bin

ENV PORT 6000

COPY /target/classes /usrapp/bin/classes
COPY /target/dependency /usrapp/bin/dependency
COPY /keyStores /usrapp/bin/keyStores

CMD ["java","-cp","./classes:./dependency/*","edu.escuelaing.arep.MatrixApp"]