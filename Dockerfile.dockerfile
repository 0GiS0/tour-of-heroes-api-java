# Usa una imagen base de OpenJDK
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo build.gradle y settings.gradle
COPY build.gradle settings.gradle ./

# Copia el directorio src
COPY src ./src

# Copia el directorio gradle
COPY gradle ./gradle

# Copia el archivo gradlew y dale permisos de ejecución
COPY gradlew ./
RUN chmod +x gradlew

# Copia el archivo gradle-wrapper.properties
COPY gradle/wrapper/gradle-wrapper.properties ./gradle/wrapper/gradle-wrapper.properties

# Construye la aplicación
RUN ./gradlew build

# Expone el puerto en el que la aplicación se ejecutará
EXPOSE 8080

# Define el comando para ejecutar la aplicación
CMD ["java", "-jar", "build/libs/tour-of-heroes-0.0.2-SNAPSHOT.jar"]