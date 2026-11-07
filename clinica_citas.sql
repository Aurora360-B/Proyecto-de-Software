DROP DATABASE IF EXISTS clinica_citas;
CREATE DATABASE clinica_citas;
USE clinica_citas;

CREATE TABLE especialidades (
id_especialidad INT AUTO_INCREMENT PRIMARY KEY, 
nombre_especialidad VARCHAR(100) NOT NULL);

CREATE TABLE consultorios (
id_consultorio INT AUTO_INCREMENT PRIMARY KEY,
numero VARCHAR(10) NOT NULL,
piso INT NOT NULL, 
sede VARCHAR(100) NOT NULL
);

CREATE TABLE pacientes (
id_paciente INT AUTO_INCREMENT PRIMARY KEY, 
tipo_documento VARCHAR (20) NOT NULL, 
numero_documento VARCHAR(20) NOT NULL UNIQUE, 
nombres VARCHAR(100) NOT NULL, 
apellidos VARCHAR(100) NOT NULL, 
fecha_nacimiento DATE,
telefono VARCHAR(20),
correo VARCHAR(100), 
direccion VARCHAR(150)
);

CREATE TABLE medicos (
id_medico INT AUTO_INCREMENT PRIMARY KEY, 
nombres VARCHAR(100) NOT NULL, 
apellidos VARCHAR (100) NOT NULL,
numero_licencia VARCHAR(50) NOT NULL UNIQUE, 
telefono VARCHAR(20), 
correo VARCHAR(100), 
id_especialidad INT NOT NULL, 
FOREIGN KEY (id_especialidad) REFERENCES especialidades(id_especialidad)
); 

CREATE TABLE citas (
id_cita INT AUTO_INCREMENT PRIMARY KEY, 
id_paciente INT NOT NULL, 
id_medico INT NOT NULL, 
id_consultorio INT NOT NULL, 
fecha DATE NOT NULL, 
hora_inicio TIME NOT NULL, 
hora_fin TIME NOT NULL, 
motivo_consulta VARCHAR(200), 
estado VARCHAR(20) DEFAULT 'Programada', 
FOREIGN KEY (id_paciente) REFERENCES pacientes (id_paciente), 
FOREIGN KEY (id_medico) REFERENCES medicos(id_medico), 
FOREIGN KEY (id_consultorio) REFERENCES consultorios(id_consultorio)
); 

CREATE TABLE historial_atencion (
id_historial INT AUTO_INCREMENT PRIMARY KEY, 
id_cita INT NOT NULL UNIQUE, 
diagnostico VARCHAR(400),
tratamiento VARCHAR(400), 
observaciones VARCHAR(400), 
fecha_registro DATETIME DEFAULT CURRENT_TIMESTAMP, 
FOREIGN KEY (id_cita) REFERENCES citas(id_cita)
);

ALTER TABLE pacientes ADD COLUMN eps VARCHAR(100); /* Se agrega columna de EPS*/
CREATE INDEX idx_paciente_documento ON pacientes (numero_documento); 

/*Inserción de datos de prueba (DML-INSERT)*/

INSERT INTO especialidades (nombre_especialidad) VALUES 
('Medicina General'),
('Pediatría'),
('Cardiología');

INSERT INTO medicos (nombres, apellidos, numero_licencia, telefono, correo, id_especialidad) VALUES 
('Laura', 'Gómez Rueda', 'MED-1023', '3011234567', 'laura.gomez@clinica.com', 1),
('Andrés', 'Pineda Castro', 'MED-1045', '3017654321', 'andres.pineda@clinica.com', 3);

INSERT INTO consultorios (numero, piso, sede) VALUES
('101', 1, 'Sede Norte'), 
('205', 2, 'Sede Norte');

INSERT INTO pacientes (tipo_documento, numero_documento, nombres, apellidos, fecha_nacimiento, telefono, correo, direccion, eps) VALUES
('CC', '1017234567', 'Mariana', 'Torres Vélez', '1994-03-12', '3159876543', 'mariana.torres@correo.com', 'Cra 45 #12-30', 'Sura');

INSERT INTO citas (id_paciente, id_medico, id_consultorio, fecha, hora_inicio, hora_fin, motivo_consulta, estado) VALUES
(1, 1, 1, '2026-10-05', '09:00:00', '09:30:00', 'Consulta general de control', 'Programada');

/*Actualización, Eliminación y Consultas (DML - `UPDATE`, `DELETE`, `SELECT`)*/

UPDATE citas
SET estado = 'Atendida'
WHERE id_cita = 1; 

SET SQL_SAFE_UPDATES = 0;

DELETE FROM citas
WHERE estado = 'Cancelado' AND fecha < '2026-01-01';

SELECT 
p.nombres AS nombre_paciente, 
p.apellidos AS apellido_paciente, 
c.fecha, 
c.hora_inicio, 
m.nombres AS medico, 
e.nombre_especialidad

FROM citas c
JOIN pacientes p ON c.id_paciente = p.id_paciente 
JOIN medicos m ON c.id_medico = m.id_medico 
JOIN especialidades e ON m.id_especialidad = e.id_especialidad 
WHERE c.fecha = '2026-10-05';

/*Creación de usuario y permisos (DCL -GRANT y REVOKE)*/

CREATE USER 'recepcion'@'localhost' IDENTIFIED BY 'H0spital$%';
GRANT SELECT, INSERT, UPDATE ON clinica_citas.citas TO 'recepcion'@'localhost';
REVOKE DELETE ON clinica_citas.citas FROM 'recepcion'@'localhost';
flush privileges; 

