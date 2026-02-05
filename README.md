# 🌤️ SkyCast

## ¿Qué es SkyCast?

**SkyCast** es una aplicación Android que permite visualizar el **clima actual** y el **pronóstico de los próximos 3 días** para una ubicación determinada.

Cuenta con una **interfaz de usuario simple, limpia e intuitiva**, pensada para que cualquier persona pueda interactuar fácilmente con la aplicación.  
Además, la app **soporta el cambio de orientación del dispositivo** (portrait y landscape), garantizando una correcta visualización de la información en ambos modos.

---

## 🛠️ Tecnologías utilizadas

La aplicación fue desarrollada utilizando las siguientes tecnologías y herramientas:

- **Android**
- **Kotlin**
- **Jetpack Compose**
- **Hilt** (inyección de dependencias)
- **Retrofit** (consumo de servicios REST)
- **Corrutinas**
- **MockK** (pruebas unitarias)

---

## 🏗️ Arquitectura

SkyCast está construida siguiendo los principios de **Clean Architecture**, organizada en **tres capas principales**:

- **Domain**
- **Data**
- **Framework (App)**

Estas capas respetan estrictamente la **regla de dependencias**, donde:

- La capa **Domain** es la más interna y **no tiene conocimiento** de ninguna otra capa.
- La capa **Data** solo tiene visibilidad hacia **Domain**.
- La capa **Framework (App)** tiene visibilidad hacia **Data** y **Domain**.


Esto permite una arquitectura **escalable, mantenible y fácil de testear**.

---

### Especificación de visibilidad – Framework (App)

<img width="414" height="84" alt="Screenshot 2026-02-05 at 3 19 20 AM" src="https://github.com/user-attachments/assets/8655c36b-bb0d-4d97-8342-3ecfcc73d326" />

### Especificación de visibilidad – Data

<img width="414" height="84" alt="Screenshot 2026-02-05 at 3 19 53 AM" src="https://github.com/user-attachments/assets/dd9ac2c9-5ea3-46b4-bb56-a293def1dbd5" />

### Especificación de visibilidad – Domain

<img width="414" height="84" alt="Screenshot 2026-02-05 at 3 21 59 AM" src="https://github.com/user-attachments/assets/08316959-6304-47ee-a61f-3d13138e8226" />


## 🧠 Patrón de presentación

Luego de definir la arquitectura, se implementó el patrón de presentación **MVI (Model–View–Intent)**.

Este patrón permite:

- Tener una **única fuente de verdad** para el estado de la UI.
- Manejar los eventos de usuario de forma clara y predecible.
- Separar de manera explícita:
  - **Estado**
  - **Eventos**
  - **Efectos secundarios**

Gracias a esto, la aplicación es más **robusta**, **fácil de depurar** y **sencilla de mantener**.

---

## 📱 Características principales

- Visualización del clima actual
- Pronóstico de los próximos 3 días
- Búsqueda de ubicaciones
- UI dinámica según el estado del clima
- Soporte para rotación de pantalla
- Arquitectura limpia + MVI
- Pruebas unitarias


## ▶️ Cómo ejecutar el proyecto en Android Studio

Para poder ejecutar **SkyCast** correctamente en Android Studio, ten en cuenta los siguientes pasos y requisitos:

---

### 🔧 Requisitos del entorno

Asegúrate de contar con:

- **Android Studio Hedgehog o superior**
- **JDK 11** (recomendado usar el que incluye Android Studio)
- **Android SDK 34**
- **Gradle** (incluido con Android Studio)
- Conexión a internet (para consumo del API del clima)

## 🤖 ¿ Se hizo uso de la inteligencia artificial ?
Si, utilice la inteligencia artificial para lo siguiente:
- Ayudarme a mappear todos los codigos de condición del clima que expone el weatherapi [ https://www.weatherapi.com/docs/weather_conditions.json ] ( mapToWeatherType(conditionCode: Int), fun      weatherBackground(type: WeatherType) )
- Ayudarme con los casos de errores(Exceptions) en las pruebas unitarias
- Me apoye pidiendo sugerencias de mejora para la UI que yo ya habia construido, entonces me recomendo styles para los textos y remover algunos Card innecesarios.
- Ayuda ubicando la sección flotante de los resultados de busqueda del Search bar, y otros temas de alineación en general.
- Ayuda con la estrategia debounce para el search bar.


## 📱 Pantallas de la aplicación

https://github.com/user-attachments/assets/17cd67a3-5dd8-4d76-aa45-b9f9615f2ded

https://github.com/user-attachments/assets/31ee51cc-224a-4d44-aefb-3c8f704f0f3c

<img width="742" height="360" alt="Screenshot 2026-02-05 at 3 47 48 AM" src="https://github.com/user-attachments/assets/d6f6494b-05f6-4896-87bf-bc46bd88062d" />
<img width="744" height="342" alt="Screenshot 2026-02-05 at 3 52 12 AM" src="https://github.com/user-attachments/assets/2f2a316b-eb5c-4912-a32a-849d150be66a" />



