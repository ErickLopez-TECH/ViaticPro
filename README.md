<div align="center">

<img src="https://capsule-render.vercel.app/api?type=waving&color=0:0d1117,100:161b22&height=120&section=header&animation=fadeIn" width="100%"/>

# 🚀 <img src="https://readme-typing-svg.demolab.com?font=Fira+Code&weight=700&size=32&duration=3000&pause=1000&color=38BDF8&center=false&vCenter=true&width=350&lines=Viatic+System;Control+Inteligente;Gestión+de+Viáticos" alt="Typing SVG" />

### *Sistema Integral de Control, Gestión y Liquidación de Viáticos*

<p align="center">
  <img src="https://img.shields.io/badge/Java-JDK-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" />
  <img src="https://img.shields.io/badge/Apache_NetBeans-1B6AC6?style=for-the-badge&logo=apachenetbeanside&logoColor=white" />
  <img src="https://img.shields.io/badge/Architecture-N--Tier-10B981?style=for-the-badge&logo=codeforces&logoColor=white" />
  <img src="https://img.shields.io/badge/Linux-Crostini-FCC624?style=for-the-badge&logo=linux&logoColor=black" />
  <img src="https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white" />
</p>

</div>

---

## 📑 Tabla de contenido
- [✨ Descripción General](#-descripción-general)
- [🎬 Vista Previa del Sistema](#-vista-previa-del-sistema)
- [🛠️ Características Principales](#️-características-principales)
- [🏗️ Arquitectura por Capas](#️-arquitectura-por-capas-n-tier)
- [📂 Estructura del Proyecto](#-estructura-del-proyecto)
- [👥 Equipo de Desarrollo](#-equipo-de-desarrollo)

---

## ✨ Descripción General

<div style="background: rgba(22, 27, 34, 0.7); border: 1px solid rgba(56, 189, 248, 0.2); padding: 20px; border-radius: 12px; backdrop-filter: blur(10px);">

**Viatic** es una solución robusta de escritorio desarrollada en **Java (Swing / AWT)** bajo el entorno de **Apache NetBeans (ANT)**. Diseñada para automatizar y optimizar el flujo de trabajo corporativo en la asignación, validación horaria, control de gastos y liquidación de viáticos para el personal de campo y viajes de trabajo.

</div>

---

## 🎬 Vista Previa del Sistema

<img width="801" height="600" alt="viaticPro" src="https://github.com/user-attachments/assets/a89cc3d4-2626-4678-82ec-7005fd99faa1" />


<div align="center">

| Módulo Principal | Panel de Control & Operaciones |
| :---: | :---: |
| <sub>*Interfaz limpia y navegación fluida mediante atajos y teclado.*</sub> | <sub>*Esquema Maestro-Detalle con validación horaria automática.*</sub> |
| <img src="https://via.placeholder.com/450x260/0d1117/38BDF8?text=Interfaz+Principal+(Viatic)" width="450px" style="border-radius: 8px; border: 1px solid rgba(56,189,248,0.3);" /> | <img src="https://via.placeholder.com/450x260/0d1117/10B981?text=Panel+Liquidaciones" width="450px" style="border-radius: 8px; border: 1px solid rgba(16,185,129,0.3);" /> |

</div>

---

## 🛠️ Características Principales

| Ícono | Módulo / Característica | Descripción Técnica |
| :---: | :--- | :--- |
| 🛡️ | **Seguridad & Accesos** | Control estricto de roles (Administrador y Usuario Normal) condicionados por estados de actividad en el sistema. |
| 📋 | **Gestión de Empleados** | Operaciones CRUD completas con validación de cédulas, estados activos/inactivos y control en tiempo real. |
| ⏱️ | **Validación de Tiempos** | Restricciones horarias automatizadas para Desayunos, Almuerzos y Cenas según políticas empresariales. |
| 🧾 | **Esquema Maestro-Detalle** | Estructura modular inspirada en sistemas de facturación para el desglose y cálculo de liquidaciones. |
| 📊 | **Reportes Dinámicos** | Generación de informes filtrados por rangos de fechas, empleados específicos y bitácora de operaciones. |

---

## 🏗️ Arquitectura por Capas (N-Tier)

El código fuente se encuentra estrictamente desacoplado para garantizar escalabilidad, mantenibilidad y facilidades de trabajo colaborativo:

```text
 ┌─────────────────────────────────────────────────────────┐
 │               PRESENTACIÓN (Swing / AWT)                │  ← Interfaces gráficas, formularios y eventos
 ├─────────────────────────────────────────────────────────┤
 │               LÓGICA (Reglas de Negocio)                │  ← Controladores, validaciones y cálculos
 ├─────────────────────────────────────────────────────────┤
 │               DATOS (Modelos / Entidades)               │  ← Clases de objetos y gestión de estructuras
 └─────────────────────────────────────────────────────────┘

ViaticPro/
└── src/
    ├── Datos/          # Entidades y modelos de datos (ObjViatico, ObjEmpleado, etc.)
    ├── Logica/         # Reglas de negocio, validaciones y controladores de operaciones
    ├── Presentacion/   # Interfaz gráfica de usuario (JFrame y JPanel Forms)
    └── Imagenes/       # Recursos gráficos, iconos y multimedia del sistema
