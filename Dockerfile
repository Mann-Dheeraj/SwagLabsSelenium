FROM UBUNTU-LTS

WORKDIR /app

COPY pom.xlm .

RUN mvn dependency:go-offline -B

COPY /src /app/

CMD ["mvn", "clean", "test"]