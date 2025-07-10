# Используем официальный образ OpenJDK
FROM openjdk:17-slim as build

# Устанавливаем компилятор Kotlin
RUN apt-get update && \
    apt-get install -y wget unzip && \
    wget https://github.com/JetBrains/kotlin/releases/download/v1.9.22/kotlin-compiler-1.9.22.zip && \
    unzip kotlin-compiler-1.9.22.zip && \
    mv kotlinc /opt/kotlinc && \
    rm kotlin-compiler-1.9.22.zip

ENV PATH="/opt/kotlinc/bin:$PATH"

# Копируем исходный файл
COPY src/Homeworks/HomeworkFour.kt /app/HomeworkFour.kt
WORKDIR /app

# Компилируем Kotlin-файл в jar
RUN kotlinc HomeworkFour.kt -include-runtime -d HomeworkFour.jar

# Финальный образ для запуска
FROM openjdk:17-slim
COPY --from=build /app/HomeworkFour.jar /app/HomeworkFour.jar
WORKDIR /app
CMD ["java", "-jar", "HomeworkFour.jar"] 