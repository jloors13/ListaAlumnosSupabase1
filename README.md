# ListaAlumnosSupabase

Aplicación Android desarrollada en Kotlin que consulta información de alumnos almacenada en Supabase utilizando el SDK oficial de Supabase y muestra los resultados en un ListView con diseño personalizado.

## Tecnologías utilizadas

- Kotlin
- Android Studio
- Supabase SDK (Postgrest)
- Glide
- Ktor
- ListView
- ArrayAdapter Personalizado

## Funcionalidades

- Consulta de alumnos desde Supabase.
- Consulta de materias desde Supabase.
- Selección de semestre mediante Spinner.
- Selección de materias mediante Spinner.
- Visualización de alumnos en ListView.
- Carga dinámica de fotografías mediante Glide.
- Transformación circular de imágenes (CircleCrop).
- Ordenamiento alfabético por nombres.

## Estructura principal

### Modelo

- Alumno.kt
- Materia.kt

### Adaptadores

- AlumnoAdapter.kt

### Actividades

- MainActivity.kt

### Configuración

- SupabaseClient.kt

## Configuración de Supabase

Crear un archivo `local.properties` en la raíz del proyecto:

```properties
SUPABASE_URL=https://tu-proyecto.supabase.co
SUPABASE_KEY=tu_clave_supabase
```

Las credenciales son cargadas mediante BuildConfig para evitar escribirlas directamente en el código fuente.

## Instalación

1. Clonar el repositorio:

```bash
git clone https://github.com/jloors13/ListaAlumnosSupabase1.git
```

2. Abrir el proyecto en Android Studio.

3. Crear el archivo `local.properties` con las credenciales de Supabase.

4. Sincronizar Gradle.

5. Ejecutar la aplicación en un emulador o dispositivo Android.

## Capturas

### Pantalla principal

- Logo institucional UTEQ.
- Selección de semestre.
- Selección de materias.
- Listado de alumnos.

### Información mostrada

- Fotografía.
- Nombre completo.
- Correo electrónico.
- Número telefónico.
- Paralelo.

## Autor

Jordan Josue Loor Suárez

Universidad Técnica Estatal de Quevedo (UTEQ)

2026