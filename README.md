<div align="center">

<img src="https://capsule-render.vercel.app/api?type=waving&color=gradient&customColorList=6,11,20,30,40&height=140&section=header&animation=fadeIn&fontColor=38BDF8" width="100%"/>

# ⚡ V I A T I C &nbsp; S Y S T E M ⚡

<h3 align="center">
  <a href="https://git.io/typing-svg">
    <img src="https://readme-typing-svg.demolab.com?font=Fira+Code&weight=600&size=20&duration=3500&pause=1000&color=38BDF8&center=true&vCenter=true&width=500&lines=Control+Inteligente+de+Viáticos;Gestión+Maestro-Detalle+Avanzada;Validación+Horaria+Automatizada;Arquitectura+Robusta+en+Java+Swing" alt="Typing SVG" />
  </a>
</h3>

<p align="center">
  <img src="https://img.shields.io/badge/Java-JDK_%2F_Swing-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" />
  <img src="https://img.shields.io/badge/Apache_NetBeans-ANT-1B6AC6?style=for-the-badge&logo=apachenetbeanside&logoColor=white" />
  <img src="https://img.shields.io/badge/Architecture-N--Tier-10B981?style=for-the-badge&logo=codeforces&logoColor=white" />
  <img src="https://img.shields.io/badge/Linux-Crostini-FCC624?style=for-the-badge&logo=linux&logoColor=black" />
  <img src="https://img.shields.io/badge/Git-Workflow-F05032?style=for-the-badge&logo=git&logoColor=white" />
</p>

</div>

---

## 📑 Tabla de Contenido
- [💎 Resumen Ejecutivo](#-resumen-ejecutivo)
- [🚀 Módulos del Sistema](#-módulos-del-sistema)
- [⏱️ Lógica de Validación Horaria](#️-lógica-de-validación-horaria)
- [🏗️ Arquitectura por Capas](#️-arquitectura-por-capas-n-tier)
- [📂 Estructura del Código](#-estructura-del-código)
- [👥 Equipo de Desarrollo](#-equipo-de-desarrollo)

---

## 💎 Resumen Ejecutivo

> **Viatic** es una solución de software de escritorio de alta precisión desarrollada en **Java (Swing/AWT)** bajo estándares empresariales. Su propósito central es automatizar el registro, control de franjas horarias, asignación de viáticos y liquidaciones corporativas, erradicando por completo los errores de cálculo manual.

---

## 🚀 Módulos del Sistema

<div align="center">

| Módulo | Descripción Funcional | Nivel de Acceso |
| :--- | :--- | :--- |
| 🛡️ **Seguridad & Login** | Control de autenticación basado en roles de usuario con validación de estados activo/inactivo. | Restringido / Administradores |
| 👥 **Gestión de Empleados** | Operaciones CRUD completas (Cédula, Nombre, Apellidos, Teléfono, Dirección y Estados). | Operativo |
| 💰 **Catálogo de Viáticos** | Administración de conceptos por alimentación (Desayunos, Almuerzos y Cenas) con montos base. | Administradores |
| 🧾 **Liquidación (Maestro-Detalle)** | Registro tipo factura con cálculo de rangos de fechas, montos y justificaciones de campo. | Operativo |
| 📊 **Reportes & Bitácora** | Informes cruzados por rangos de fechas, filtros por empleado y trazabilidad de operaciones. | General |

</div>

---

<div align="center" style="background: linear-gradient(135deg, rgba(22, 27, 34, 0.85), rgba(13, 17, 23, 0.95)); border: 1px solid rgba(56, 189, 248, 0.3); padding: 25px; border-radius: 16px; box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.37); backdrop-filter: blur(8px);">

  <h3 style="color: #38BDF8; margin-top: 0; font-family: 'Fira Code', monospace; letter-spacing: 1px;">
    ⚡ C O R E &nbsp; D E V &nbsp; T E A M ⚡
  </h3>
  
  <p style="color: #94A3B8; font-size: 14px; margin-bottom: 20px;">
    Arquitectura, desarrollo de software y control de calidad del sistema.
  </p>

  <table style="border-collapse: collapse; width: 100%; color: #E2E8F0;">
    <thead>
      <tr style="border-bottom: 1px solid rgba(56, 189, 248, 0.2);">
        <th style="padding: 10px; text-align: left;">Desarrollador</th>
        <th style="padding: 10px; text-align: left;">Rol Asignado</th>
        <th style="padding: 10px; text-align: center;">GitHub</th>
      </tr>
    </thead>
    <tbody>
      <tr style="border-bottom: 1px solid rgba(255, 255, 255, 0.05);">
        <td style="padding: 12px; font-weight: bold; color: #38BDF8;">Erick Jasiel López Borge</td>
        <td style="padding: 12px;">Core, Lógica de Negocio & Arquitectura</td>
        <td style="padding: 12px; text-align: center;">
          <a href="https://github.com/ErickLopez-TECH"><img src="https://img.shields.io/badge/GitHub-Profile-181717?style=flat-square&logo=github" alt="GitHub"></a>
        </td>
      </tr>
      <tr style="border-bottom: 1px solid rgba(255, 255, 255, 0.05);">
        <td style="padding: 12px; font-weight: bold; color: #38BDF8;">Dylan Álvarez</td>
        <td style="padding: 12px;">Interfaces Gráficas & Módulos</td>
        <td style="padding: 12px; text-align: center;">
          <a href="https://github.com/"><img src="https://img.shields.io/badge/GitHub-Profile-181717?style=flat-square&logo=github" alt="GitHub"></a>
        </td>
      </tr>
      <tr>
        <td style="padding: 12px; font-weight: bold; color: #38BDF8;">David Reyes</td>
        <td style="padding: 12px;">Soporte Técnico & QA</td>
        <td style="padding: 12px; text-align: center;">
          <a href="https://github.com/"><img src="https://img.shields.io/badge/GitHub-Profile-181717?style=flat-square&logo=github" alt="GitHub"></a>
        </td>
      </tr>
    </tbody>
  </table>

</div>

## ⏱️ Reglas y Lógica de Validación Horaria

El sistema incorpora validaciones algorítmicas estrictas para la asignación de viáticos alimentarios según los horarios de salida y llegada:

```text
 ╔════════════╦════════════════════╦════════════════════╗
 ║  VIÁTICO   ║    HORA SALIDA     ║    HORA LLEGADA    ║
 ╠════════════╬════════════════════╬════════════════════╣
 ║  Desayuno  ║    ≤ 07:00 hrs     ║    ≥ 10:00 hrs     ║
 ║  Almuerzo  ║    ≤ 10:00 hrs     ║    ≥ 14:00 hrs     ║
 ║  Cena      ║    ≤ 16:00 hrs     ║    ≥ 20:00 hrs     ║
 ╚════════════╩════════════════════╩════════════════════╝

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




