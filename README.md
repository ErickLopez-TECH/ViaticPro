<div align="center">

# 🚀 Viatic

### Sistema de Control y Gestión de Viáticos

Aplicación de escritorio para la administración y control de **viáticos, gastos y liquidaciones**,
construida con arquitectura por capas y diseño modular.

![Java](https://img.shields.io/badge/Java-JDK-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![NetBeans](https://img.shields.io/badge/Apache_NetBeans-1B6AC6?style=for-the-badge&logo=apachenetbeanside&logoColor=white)
![Linux](https://img.shields.io/badge/Linux-Crostini-FCC624?style=for-the-badge&logo=linux&logoColor=black)
![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white)

</div>

---

## 📑 Tabla de contenido

- [🎬 Demostración visual](#-demostración-visual)
- [✨ Características](#-características)
- [🏗️ Arquitectura](#️-arquitectura-por-capas-n-tier)
- [📂 Estructura del proyecto](#-estructura-del-proyecto)
- [🛠️ Tecnologías](#️-tecnologías-utilizadas)
- [🗺️ Roadmap](#️-roadmap)
- [👤 Autor](#-autor)
- [🤝 Conectemos](#-conectemos)

---

## 🎬 Demostración visual

<div align="center">
 her
 
 <br>
 <sub><i>Gestión y registro de solicitudes y liquidaciones de viáticos en tiempo real.</i></sub>
</div>

---

## ✨ Características

| | Funcionalidad | Descripción |
|---|---|---|
| 📋 | **Gestión de solicitudes** | Módulo completo para **registrar, consultar, modificar y aprobar** viáticos de forma dinámica. |
| 🗂️ | **Control de gastos** | Clasificación y cálculo automatizado de asignaciones por concepto de transporte, hospedaje y alimentación. |
| 🎨 | **Interfaz limpia** | Menú de navegación intuitivo con controles de acceso y validación de campos numéricos y de texto. |
| 🧱 | **Código mantenible** | Separación estricta de responsabilidades para facilitar el trabajo en equipo y la escalabilidad. |

---

## 🏗️ Arquitectura por capas (N-Tier)

El proyecto sigue una separación estricta de responsabilidades:

├─────────────────────────────────────┤
│   Presentación  (Swing / AWT)       │  ← Interfaz gráfica de usuario
├─────────────────────────────────────┤
│   Lógica        (Reglas de negocio) │  ← Controladores de cálculos y operaciones
├─────────────────────────────────────┤
│   Datos         (Modelos / Clases)  │  ← Estructuras de entidades y manejo local
└─────────────────────────────────────┘

---

## 📂 Estructura del proyecto

```text
ViaticPro/
└── src/
    ├── Datos/          # Entidades y modelos de datos (ObjViatico, ObjEmpleado, etc.)
    ├── Logica/         # Reglas de negocio y controladores de operaciones
    ├── Presentacion/   # Interfaz gráfica de usuario (Swing / AWT)
    └── Imagenes/       # Recursos gráficos y multimedia del sistema

👤 Autor
Erick Lopez, Dylan Alvarez y David Reyes
Desarrollador Java · Apasionado por los sistemas de gestión y la optimización de procesos.
