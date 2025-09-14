# 1. Start with an official Maven + JDK image
FROM maven:3.9.9-eclipse-temurin-17 AS build

# 2. Set working directory inside container
WORKDIR /app

# 3. Copy only pom.xml first (for dependency caching)
COPY pom.xml .

# 4. Download dependencies (so they get cached unless pom.xml changes)
RUN mvn dependency:go-offline -B

# 5. Now copy the rest of your project
COPY src ./src
COPY testng.xml .

# 6. Run tests when container starts
CMD ["mvn", "clean", "test"]
