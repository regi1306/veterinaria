🐾 API REST para Gestión de Veterinaria 🐾

Este proyecto es una guía básica para la implementación de una API REST con Java y Spring Boot, enfocada en estudiantes que desean comprender la arquitectura REST, 
el uso de Spring Boot y la interacción con bases de datos relacionales mediante MySQL.

📌 Descripción General
Sistema de gestión para una veterinaria que permite administrar veterinarios, especialidades, mascotas, clientes, consultas, etc. 
La aplicación se construyó usando Spring Boot y se prueba mediante Postman con persistencia en MySQL, utilizando XAMPP como servidor local.


🛠️ Herramientas Utilizadas
Tecnología	Versión	Uso Principal
Java	17+	Lenguaje de programación
Spring Boot	Última	Framework para desarrollo de la API REST
IntelliJ IDEA	Community	IDE de desarrollo
MySQL	8+	SGDB para almacenamiento
XAMPP	Última	Servidor local que incluye MySQL
Postman	Actual	Testing de endpoints

🔧 Instalación y Configuración
1. Instalación de Herramientas
•	XAMPP (MySQL)
•	Postman
•	Spring Initializr
•	IntelliJ IDEA

2.
  Paso 1: Iremos a crear nuestro proyecto base en el tercer enlace provisto anteriormente,
 debemos agregar las siguientes dependencias (la dependencia de MySQL Driver cambiará si utiliza un gestor de base de datos diferente)
 
![image](https://github.com/user-attachments/assets/3831d340-cbf4-4fdf-9959-62cdb5d7e0eb)

Paso 2: Luego de haber dado GENERATE, procedemos a buscar el archivo en nuestro directorio seleccionado (por defecto será en descargas), extraemos el .zip que nos dejará listo el proyecto base para poder empezar nuestro desarrollo.
 
![image](https://github.com/user-attachments/assets/7c05b6c9-146c-4fee-be7f-e3c868da2308)


Paso 3: Abrimos nuestro proyecto desde IntelliJ IDEA.
 
![image](https://github.com/user-attachments/assets/cdcf52e3-5470-47a5-8747-c7f2d01540b6)

 

📂 Estructura del Proyecto

3. Configurar la Base de Datos: Veterinaria
El sistema utiliza una base de datos relacional desarrollada en MySQL. A continuación, se detalla la estructura de las tablas y algunos datos de ejemplo insertados para fines de pruebas y desarrollo.
1.	Iniciar el servicio MySQL desde XAMPP.
2.	Crear una base de datos llamada veterinaria

CREATE DATABASE IF NOT EXISTS veterinaria;
USE veterinaria;

CREATE TABLE cliente (
id_cliente INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(100) NOT NULL,
telefono VARCHAR(9),
correo VARCHAR(100),
direccion VARCHAR(150)
);

CREATE TABLE animal (
    id_animal INT AUTO_INCREMENT PRIMARY KEY,
    nombre_mascota VARCHAR(50) NOT NULL,
    especie VARCHAR(50) NOT NULL,
    raza VARCHAR(50),
    edad INT NOT NULL,
    peso FLOAT NOT NULL,
    condiciones_medicas TEXT NOT NULL,
    id_cliente INT NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente)
);


CREATE TABLE veterinario (
    id_veterinario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    especialidad VARCHAR(50),
    numero_licencia VARCHAR(20) NOT NULL,
    telefono VARCHAR(9) NOT NULL,
	horario_atencion VARCHAR(100)
);

CREATE TABLE consulta (
    id_consulta INT AUTO_INCREMENT PRIMARY KEY,
    fecha_consulta DATE NOT NULL,
    motivo VARCHAR(255) NOT NULL,
    diagnostico TEXT,
    tratamiento VARCHAR(100) NOT NULL,
    id_veterinario INT NOT NULL,
    id_animal INT NOT NULL,
    FOREIGN KEY (id_veterinario) REFERENCES veterinario(id_veterinario),
    FOREIGN KEY (id_animal) REFERENCES Animal(id_animal)
);

CREATE TABLE consultorio (
id_consultorio INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(100) NOT NULL,
direccion VARCHAR(150) NOT NULL, 
correo VARCHAR(100),
telefono VARCHAR(9),
horario_atencion VARCHAR(150)
);

📋 Datos de Prueba Insertados
Se incluyen datos de ejemplo para pruebas iniciales:
•	Veterinarios: 10 registros con distintas especialidades.
•	Consultas: 10 registros asociando veterinarios con animales.
•	Animales: 10 registros de distintas especies y condiciones médicas.
•	Consultorios: 10 ubicaciones diferentes con información de contacto.
•	Clientes: 10 registros con información de contacto y dirección.


INSERT INTO veterinario (nombre, especialidad, numero_licencia, telefono, horario_atencion) VALUES
('Dra. Andrea Salas', 'Medicina general', 'VET123456', '7234-4321', 'Lunes a Viernes, 9am - 5pm'),
('Dr. Carlos Gómez', 'Cirugía', 'VET654321', '912345678', 'Lunes a Sábado, 10am - 6pm'),
('Dra. Mariana Ruiz', 'Dermatología', 'VET112233', '7313-7665', 'Martes a Viernes, 8am - 4pm'),
('Dr. Felipe Torres', NULL, 'VET445566', '9113-3440', 'Lunes a Viernes, 1pm - 7pm'),
('Dra. Laura Paredes', 'Oncología', 'VET778899', '8744-1355', 'Miércoles y Jueves, 9am - 3pm'),
('Dr. Oscar Linares', 'Exóticos', 'VET998877', '7012-3456', 'Lunes a Viernes, 11am - 6pm'),
('Dra. Ingrid Valdez', 'Neurología', 'VET334455', '3322-1100', 'Martes a Sábado, 10am - 5pm'),
('Dr. Mateo Silva', 'Oftalmología', 'VET667788', '4455-6677', 'Lunes a Miércoles, 9am - 2pm'),
('Dra. Fernanda Castro', 'Cardiología', 'VET556677', '5566-7788', 'Lunes a Viernes, 2pm - 8pm'),
('Dr. Tomás Leiva', 'Odontología', 'VET112244', '6677-8899', 'Sábados, 9am - 1pm');


INSERT INTO consulta (fecha_consulta, motivo, diagnostico, tratamiento, id_veterinario, id_animal) VALUES
('2023-05-01', 'Chequeo general', 'Salud estable', 'Vitaminas y desparasitación', 1, 1),
('2024-02-14', 'Rasquidos frecuentes', 'Alergia a pollo', 'Dieta hipoalergénica', 3, 2),
('2023-11-20', 'Dificultad para respirar', 'Problema bronquial', 'Nebulizaciones', 2, 3),
('2024-01-10', 'Revisión post operatoria', 'Buena cicatrización', 'Curaciones y control de dolor', 1, 4),
('2023-09-05', 'Vacunación anual', 'En buenas condiciones', 'Vacuna VHD y mixomatosis', 4, 5),
('2023-08-12', 'Dolor al caminar', 'Displasia detectada', 'Fisioterapia semanal', 5, 6),
('2023-12-01', 'Falta de apetito', 'Inicio de insuficiencia renal', 'Medicamento renal y dieta especial', 6, 7),
('2024-03-20', 'Problemas al comer semillas', 'Pico quebrado', 'Lima y control', 6, 8),
('2023-06-15', 'Rigidez en patas traseras', 'Artritis avanzada', 'Antiinflamatorios y control mensual', 7, 9),
('2023-10-10', 'Primera revisión', 'Animal sano', 'Recomendación de dieta y hábitat', 8, 10);

INSERT INTO animal (nombre_mascota, especie, raza, edad, peso, condiciones_medicas, id_cliente) VALUES
('Max', 'Perro', 'Labrador', 5, 30.5, 'Ninguna', 1),
('Luna', 'Gato', 'Siames', 3, 4.2, 'Alergia alimentaria', 2),
('Rocky', 'Perro', 'Bulldog', 7, 25.0, 'Problemas respiratorios', 3),
('Nala', 'Gato', 'Maine Coon', 2, 5.3, 'Esterilizada', 4),
('Toby', 'Conejo', 'Enano', 1, 1.1, 'Chequeo general', 5),
('Bella', 'Perro', 'Golden Retriever', 4, 28.7, 'Displasia de cadera', 6),
('Simba', 'Gato', 'Bengalí', 6, 5.0, 'Insuficiencia renal', 7),
('Coco', 'Loro', 'Amazonas', 10, 0.9, 'Pico dañado', 8),
('Lola', 'Perro', 'Poodle', 8, 12.0, 'Artritis', 9),
('Chispa', 'Hámster', 'Roborovski', 1, 0.2, 'Sin antecedentes', 10);

INSERT INTO consultorio (nombre, direccion, correo, telefono, horario_atencion) VALUES
('ChivoPet', 'Av. Siempre Viva #123, San Salvador', 'contacto@pchivopet.com', '2456-9632', 'Lunes a Viernes: 8am - 6pm'),
('Centro Veterinario El Buen Amigo', 'Calle Luna #456, Santa Ana', 'info@buenamigo.com', '2244-5678', 'Lunes a Sábado: 9am - 5pm'),
('VetSalud Animal Center', 'Boulevard del Hipódromo #789, San Miguel', 'vetsalud@veterinariasv.com', '2266-7890', 'Todos los días: 7am - 7pm'),
('AnimalCare', 'Av. Roosevelt #321, Soyapango', 'contacto@animalcare.com', '7732-5678', 'Lunes a Viernes: 9am - 6pm'),
('Mundo Animal', 'Colonia Médica #15, San Salvador', 'info@mundoanimal.com', '7133-2211', 'Lunes a Domingo: 8am - 4pm'),
('Huellitas Felices', 'Calle Los Pinos #88, Santa Tecla', 'huellitas@felices.com', '7988-3344', 'Martes a Sábado: 10am - 7pm'),
('Veterinaria El Arca', 'Plaza Merliot, Local 12, Antiguo Cuscatlán', 'elarca@vetsv.com', '7000-1122', 'Lunes a Viernes: 8am - 5pm'),
('Clínica Animal Vida Sana', 'Centro Comercial Las Palmas, San Marcos', 'vidasana@clinicasv.com', '7222-9988', 'Sábado y Domingo: 9am - 3pm'),
('PetMedic Veterinaria', 'Bulevar Constitución #432, Mejicanos', 'petmedic@correo.com', '7555-4433', 'Todos los días: 24 horas'),
('Veterinaria San Rafael', 'Km 5 Carretera a Santa Ana, Lourdes', 'sanrafael@vet.com', '7999-6655', 'Lunes a Viernes: 7am - 4pm');

INSERT INTO cliente (nombre, telefono, correo, direccion) VALUES
('Carlos Ramírez', '7123-4567', 'carlos.ramirez@example.com', 'Colonia Escalón, San Salvador'),
('María Gómez', '7890-1234', 'maria.gomez@example.com', 'Residencial Altavista, Soyapango'),
('Luis Torres', '7001-9988', 'luis.torres@example.com', 'Barrio San Miguelito, San Miguel'),
('Andrea Martínez', '7456-3322', 'andrea.martinez@example.com', 'Colonia San Benito, San Salvador'),
('Javier López', '7012-4567', 'javier.lopez@example.com', 'Reparto Las Cañas, Ilopango'),
('Patricia Hernández', '7654-9087', 'patricia.hdz@example.com', 'Colonia Miramonte, San Salvador'),
('Ricardo Molina', '7899-2244', 'ricardo.molina@example.com', 'Urbanización El Trébol, Santa Ana'),
('Camila Vásquez', '7200-3344', 'camila.vasquez@example.com', 'Colonia Los Alpes, Santa Tecla'),
('Fernando Castillo', '7003-5566', 'fernando.castillo@example.com', 'Barrio El Centro, San Miguel'),
('Eduardo Martínez', '7999-8877', 'eduardo.martinez@example.com', 'Residencial Monteverde, Apopa');
SHOW TABLES;

3.	Configurar las credenciales en el archivo application.properties:

 ![image](https://github.com/user-attachments/assets/bd95f6fa-7247-4907-ad90-053e79c5cfe0)


🐾 Gestión de Animales

📦 Entidad: AnimalEntity
Esta clase representa a los animales registrados en la veterinaria. Contiene los datos relevantes sobre cada mascota, incluyendo su relación con el cliente dueño del animal.
Atributos:
•	idAnimal: Identificador único del animal.
•	nombreMascota: Nombre de la mascota.
•	especie: Especie (perro, gato, etc.).
•	raza: Raza de la mascota.
•	edad: Edad en años.
•	peso: Peso en kilogramos.
•	condicionesMedicas: Condiciones médicas relevantes.
•	cliente: Relación con el propietario (cliente), asociada con @ManyToOne.

📤 DTOs
•	AnimalDto: Objeto de transferencia que muestra una vista simplificada del animal con el nombre del cliente.
o	Campos: nombreMascota, especie, raza, nombreCliente.
•	AnimalRequestDto: DTO de solicitud para registrar o actualizar animales.
o	Campos: nombreMascota, especie, raza, edad, peso, condicionesMedicas, idCliente.


🗃️ Repositorio: AnimalRepository
Extiende JpaRepository<AnimalEntity, Long>, permitiendo el uso de métodos CRUD predefinidos y define una consulta personalizada:
@Query("SELECT new parcial.veterinaria.entities.dto.AnimalDto(" +
       "a.nombreMascota, a.especie, a.raza, c.nombre) " +
       "FROM AnimalEntity a JOIN a.cliente c")
List<AnimalDto> obtenerAnimalesConDueños();


🧠 Service
Interfaz: IAnimal
List<AnimalEntity> findAll();
AnimalEntity save(AnimalEntity animal);
AnimalEntity findById(Long id);
AnimalEntity update(Long id, AnimalEntity animal);
void delete(Long id);
List<AnimalDto> obtenerAnimalesConDueños();
Implementación: AnimalImpl
Implementa las operaciones CRUD, además de una función para obtener animales con sus dueños. Verifica si los registros existen antes de actualizarlos o eliminarlos.


🌐 Controlador REST: AnimalController
Define los endpoints HTTP para acceder y gestionar los animales. Está ubicado en la ruta base /process.
Método	Ruta	Descripción
GET	/process/animales	Lista todos los animales.
POST	/process/animales	Crea un nuevo animal.
GET	/process/animales/dto	Lista animales con nombre de sus dueños.
GET	/process/animales/{id}	Busca un animal por su ID.
PUT	/process/animales/{id}	Actualiza un animal por ID.
DELETE	/process/animales/{id}	Elimina un animal por ID.
Respuestas personalizadas:
•	Cuando no se encuentra un animal, se devuelve un objeto MessageResponse con el mensaje de error.




🖱️ Ejecución de la API
1.	Abrí el proyecto con IntelliJ.
2.	Ejecutá la clase principal VeterinariaApplication.java.
3.	Usá Postman para probar los endpoints disponibles de la API REST.


💻 Ejemplos de Endpoints con Postman
El GET sirve para obtener todos los datos de una table, en nuestro proyecto tenemos 5 tablas: Animal, Consultorio, Cliente, Consulta y Veterinario.

En Postman se obtiene los datos de cada tabla hacienda GET con http://localhost:8080/process/ y el nombre que le hemos puesto en el @GetMapping y @PostMapping

 ![image](https://github.com/user-attachments/assets/5cb5a21e-b737-411c-9e95-e3032dac7c90)


•	GET http://localhost:8080/process/consultas
•	GET http://localhost:8080/process/veterinarios 
•	GET http://localhost:8080/process/consultorios 
•	GET http://localhost:8080/process/clientes 
•	GET http://localhost:8080/process/animales 

Para POST se usa el mismo link, pero antes agregar esto en Headers:
 ![image](https://github.com/user-attachments/assets/b027d166-0402-4c9a-80de-d32ef71c5b0c)

En Key: Content-Type y en Value: application/json
Luego irse a Body y a raw
Y ahí escribir lo que se agregara usando POST,
Ejemplo en Consultorio:
![image](https://github.com/user-attachments/assets/b1b080db-c692-4ae1-af21-f57fabf8d574)

 
Esa es la estructura en el Body, no se pone id porque se genera automático, después de agregar los datos nuevos le damos a SEND y vemos abajo que se guardó, si hacemos de nuevo un GET ya nos saldrían todos los datos más el nuevo que acabamos de agregar.

GET con DTO:
http://localhost:8080/process/veterinarios/dto
http://localhost:8080/process/consultas/dto
http://localhost:8080/process/animales/dto

📘 Documentación Adicional
•	Documentación de Spring Boot
•	Documentación de MySQL
•	Guía de Postman
