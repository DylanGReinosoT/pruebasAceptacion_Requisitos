import React, { useState } from "react";

export default function TriggerReport() {
  const [fechaInicio, setFechaInicio] = useState("");
  const [fechaFin, setFechaFin] = useState("");
  const [reporteGenerado, setReporteGenerado] = useState(false);

  const handleGenerarReporte = () => {
    if (fechaInicio && fechaFin) {
      setReporteGenerado(true);
    } else {
      alert("Por favor selecciona ambas fechas.");
    }
  };

  return (
    <div>
      <h2 className="Titulo">Generar Reporte</h2>
      <input
        id="fechaInicio"
        type="date"
        value={fechaInicio}
        onChange={(e) => setFechaInicio(e.target.value)}
      />
      <input
        id="fechaFin"
        type="date"
        value={fechaFin}
        onChange={(e) => setFechaFin(e.target.value)}
      />
      <button id="generarReporteButton" onClick={handleGenerarReporte}>
        Generar Reporte
      </button>

      {reporteGenerado && (
        <div id="reporte">
          <h3>
            Reporte generado del {fechaInicio} al {fechaFin}
          </h3>
          <p>Detalles del inventario de materia prima...</p>
        </div>
      )}
    </div>
  );
}
