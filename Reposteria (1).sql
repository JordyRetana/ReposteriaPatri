drop schema if exists reposteria_patri;
drop user if exists administrador;
CREATE SCHEMA reposteria_patri;

/*Se crea un usuario para la base de datos llamado "administrador" y tiene la contraseña "admin_p"*/
create user 'administrador'@'%' identified by 'admin_p';

/*Se asignan los prvilegios sobr ela base de datos TechShop al usuario creado */
grant all privileges on reposteria_patri.* to 'administrador'@'%';
flush privileges;

USE reposteria_patri;

CREATE TABLE users(
	id_user int auto_increment primary key not null,
    nombre varchar(15) not null,
    apellido varchar(15) not null,
    username varchar(40) not null,
    password varchar(512) not null
);

CREATE TABLE categoria(
	id_categoria int primary key auto_increment not null,
    nombre varchar(20)
);

CREATE TABLE producto(
	id_producto int primary key auto_increment not null,
    nombre varchar(30) not null,
    descripcion varchar(1800) not null,
    precio double not null,
    imagen varchar(1024),
    activo bool not null,
    id_categoria int not null,
    foreign key(id_categoria) references categoria(id_categoria)
);

CREATE TABLE factura(
	id_factura int auto_increment primary key not null,
    fecha date,
    total double,
    id_user int not null,
    id_producto int not null,
    foreign key(id_user) references users(id_user),
    foreign key(id_producto) references producto(id_producto)
);


CREATE TABLE venta(
	id_venta int auto_increment primary key not null,
    precio double,
    cantidad int,
    id_factura int not null,
    id_producto int not null,
    foreign key(id_factura) references factura(id_factura),
    foreign key(id_producto) references producto(id_producto)
);

CREATE TABLE galeria(
	id_imagen int auto_increment primary key,
    imagen varchar(1024)
);

INSERT INTO users(nombre,apellido,username, password) values
('Kevin','Ruíz', 'kruiz20','kr_1234.'),
('Randall','Cordero', 'rcordero08','rc_1994.');

INSERT INTO categoria(nombre)VALUES
('Tortas y postres'),('Panadería');

-- INSERTAR LA RUTA DE LA IMAGEN EN LOS ESPACIOS.
INSERT INTO producto(nombre,descripcion,precio,imagen,activo,id_categoria) VALUES
('Dama blanca','Bizcocho esponjoso de vainilla bañado en salsa 3 leches, decorado con placas lisas de chocolate blanco y lluvia de chocolate blanco por encima. Uno de los más vendidos
en toda nuestra historia',5900,'https://github.com/josuemc12/imagenes_reposteria/blob/main/Dama%20blanca.jpg?raw=true',true,1),
('Muselina de fresas','Nuestro clásico postre en capas de bizcochuelo de vainilla, crema chantilly y fresas naturales. Va cubierto con fresas y salsa de fresas. Por su suavidad, sabor y frescura es uno de los postres preferidos de todos en todas las épocas.',
4300,'https://reposteriaelportal.com/cdn/shop/products/WhatsAppImage2022-03-22at12.31.54PM_1080x.jpg?v=1655218576',true,1),
('Bizcocho negro', 'Nuestro tradicional bizcocho negro de novias es una exclusiva receta que combina de manera magistral una selección de frutas glaseadas y envinadas entre ellas: ciruelas pasas, cerezas, brevas, nueces, especias y finos licores.',
2500,'https://github.com/josuemc12/imagenes_reposteria/blob/main/bizcocho.jpg?raw=true',true,1),
('Red Velvet','Nuestra versión de la tradicional receta americana del bizcocho Red velvet con sabor a vainilla y un toque de cocoa que se caracteriza por su color rojo-marrón.
3 capas de bizcocho entreteladas con crema de queso ligeramente cítrica para realzar su sabor',
7500,'https://github.com/josuemc12/imagenes_reposteria/blob/main/red%20velvet.jpg?raw=true',true,1),
('Amaretto','4 capas de bizcocho: 2 de chocolate y 2 de vainilla remojadas con licor de Amaretto y entreteladas con crema chantillí, cubierto con crema.',
3000,'https://github.com/josuemc12/imagenes_reposteria/blob/main/amaretto%202.jpg?raw=true',true,1),
('Cheesecake de fresa','Cheesecake clásico refrigerado sobre base de galletas trituradas, de textura cremosa con un ligero sabor a queso, cubierto con una salsa natural a base de fresa.',
3000,'https://raw.githubusercontent.com/josuemc12/imagenes_reposteria/main/cheesecake%20fresa.jpg.webp',true,1),
('Croqueta','Deliciosa croqueta de Pollo, especial e ideal para deleitar en tus eventos mas especiales. compra minima 5 unidades',
3200,'https://github.com/josuemc12/imagenes_reposteria/blob/main/croquetas.jpeg?raw=true',true,2),
('Pastel de pollo','Pastel hojaldrado relleno de pollo y verduras, tamaño mediano para entre 6 y 8 personas',
10000,'https://github.com/josuemc12/imagenes_reposteria/blob/main/pastel%20de%20pollo.jpg?raw=true',true,2),
('Galletas','Exquisita y tradicional receta de nuestras galletas de mantequilla en hermosa presentación en forma de corazón.
Estuche x 28 Unidades', 4500,'https://github.com/josuemc12/imagenes_reposteria/blob/main/galletas.jpg?raw=true',true,2),
('Mini alfajores','Galleta de alfajor con nuestra receta tradicional de textura muy suave, rellenas de arequipe y coco alrededor.
Estuche x 9 unidades',6900,'https://github.com/josuemc12/imagenes_reposteria/blob/main/mini%20alfajores.jpg?raw=true',true,2),
('Brownie','Especial brownie de chocolate. 
Cantidad mínima a solicitar: 3 unidades',5100,'https://github.com/josuemc12/imagenes_reposteria/blob/main/brownie.jpg?raw=true',true,2),
('Deditos de queso','Deliciosos deditos de queso sabana, especiales para deleitar tus eventos mas especiales.
Compra mínima 5 unidades',2000,'https://github.com/josuemc12/imagenes_reposteria/blob/main/deditos%20de%20queso.jpg?raw=true',true,2);

INSERT INTO galeria(imagen) VALUES -- insertar la ruta de las imagenes
('https://www.dropbox.com/scl/fi/th6o4vr2lcyq28xboflnu/muselina-de-fresa.jpg?rlkey=vdrup0lsr7snln2deyt64lx3m&st=lpnvt69h&dl=0'),
('https://drive.google.com/file/d/1OMI05OCvGh8r5hZs8ROIiodCpuXEr2cu/view?usp=share_link'),
('https://www.dropbox.com/scl/fi/49ar1p0ruy8lj0lbt85sf/mini-alfajores.jpg?rlkey=knz08yhjqwyoko73h3af9yyo0&st=6kzphncw&dl=0'),
('https://www.dropbox.com/scl/fi/pcvdgyov7phys9ly18qe7/red-velvet.jpg?rlkey=umywd5mutca95qh7h1p5rlcih&st=vmotkhb7&dl=0'),
('https://www.dropbox.com/scl/fi/3h3w04e9h903i4239ezps/cheesecake-fresa.jpg.webp?rlkey=d85yhl4yytncougfvzap9upnb&st=mrsr7tuw&dl=0'),
('https://www.dropbox.com/scl/fi/l64nzzmoob9zmxdo8az3v/bizcocho.jpg?rlkey=n9t2e6uk7ntk4ob2oknmevs9r&st=aom5v967&dl=0'),
('https://www.dropbox.com/scl/fi/psji4fs1jtzd6ej7hf6x3/deditos-de-queso-2.jpg?rlkey=yl02rf4r0wltm5bvoaa2x63ps&st=fuom9nd4&dl=0');

CREATE TABLE clientes(
	id_cliente int auto_increment primary key not null,
    nombre varchar(15) not null,
    apellido varchar(15) not null,
    username varchar(40) not null,
    password varchar(512) not null
);

CREATE TABLE consulta (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(200) NOT NULL,
    apellido VARCHAR(200) NOT NULL,
    username VARCHAR(200) NOT NULL,
    city VARCHAR(200) NOT NULL,
    state VARCHAR(200) NOT NULL,
    zip VARCHAR(200) NOT NULL,
    correo VARCHAR(200) NOT NULL,
    telefono VARCHAR(14) NOT NULL,
    mensaje VARCHAR(2048) NOT NULL
);
CREATE TABLE preguntas (
    id_cliente_preguntas INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(200) NOT NULL,
    apellido VARCHAR(200) NOT NULL,
    comentario VARCHAR(200) NOT NULL,
    imagen VARCHAR(2500) NOT NULL
);
INSERT INTO preguntas (nombre, apellido, comentario, imagen) VALUES
('Ana', 'Gómez', 'Los pasteles de esta pastelería son los más deliciosos que he probado. ¡Siempre vuelvo por más!', 'https://www.topgastronomico.es/wp-content/uploads/2022/12/AdobeStock_204192079-scaled.jpeg'),
('Luis', 'Fernández', 'Cada bocado es una explosión de sabor. Los postres son simplemente exquisitos.', 'https://assets.tmecosys.com/image/upload/t_web767x639/img/recipe/ras/Assets/7290B3AB-13D0-4DCB-AC2C-60F3A8789679/Derivates/09603b42-66e9-4fd9-87ea-0a55ddebf242.jpg'),
('María', 'Rodríguez', 'La atención es increíble y los pasteles son perfectos para cualquier ocasión. ¡Altamente recomendado!', 'https://www.cocinavital.mx/wp-content/uploads/2022/05/pastel-de-fresas-con-merengues-634x420.jpg'),
('Carlos', 'Martínez', 'Cada pastel es una obra de arte. Me encanta cómo combinan los sabores.', 'https://i.pinimg.com/736x/72/21/8d/72218d6cf86cfbf0892eb40a92b06e1e.jpg'),
('Sofía', 'López', 'Un lugar encantador con los postres más ricos. Cada visita es una experiencia dulce.', 'https://static.vecteezy.com/system/resources/previews/004/857/415/non_2x/tasty-cake-kawaii-cartoon-character-vector.jpg'),
('Juan', 'Pérez', 'Los mejores postres de la ciudad. La calidad y el sabor son incomparables.', 'https://peopleenespanol.com/thmb/fvZeTNS5koecZ2Yd0nKdfQAskQU=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/pastel-de-pic3b1a-sencillo-2000-ae38cbb8fff94cbf8f7a17ff14189ab7.jpg');

CREATE TABLE galerias(
	id_imagen int auto_increment primary key,
    imagen varchar(1024)
);
INSERT INTO galerias(imagen) VALUES -- insertar la ruta de las imagenes
('https://i0.wp.com/thesweetmolcajete.com/wp-content/uploads/2020/06/WPRM-Receta-de-Pastel-de-Tres-Leches.jpg?fit=733%2C733&ssl=1'),
('https://ds1e83w8pn0gs.cloudfront.net/fotosmultisite/502481-1.jpg'),
('https://t1.uc.ltmcdn.com/es/posts/5/7/7/como_hacer_un_pastel_de_tres_leches_26775_orig.jpg'),
('https://gastronomicainternacional.com/wp-content/uploads/2020/04/reposteria-2.jpg'),
('https://www.bettycrocker.lat/mx/wp-content/uploads/sites/2/2023/04/Sprinkle-Party-Cake.jpg'),
('https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEhW8C5pNE3Zo5cZMelr61zHJLnIi4M4eMGF4675sZ-Zq-swqDjrZoobXauDsxoSO2Iq99OawbUmqJSOrevo3ccpgnUiX1kFTJxRQfLw0K3ojJUq-3UGAGlxQMlHCpajNsYNfX1e_44Tub0/s1600/IMG_4707.JPG'),
('https://content-cocina.lecturas.com/medio/2021/05/17/paso_a_paso_para_realizar_mona_de_pascua_de_fresa_con_coco_y_merengues_resultado_final_930ec11a_600x600.jpg'),
('https://www.pasteleriaok.com.mx/img/catalogo/productos/producto-348-img-442.png'),
('https://dulcerojo.com.mx/wp-content/uploads/2022/07/209.jpg'),
('https://www.dolci.com.mx/cdn/shop/files/pastel-chocolate-dolci.jpg?v=1711133660&width=1445'),
('https://i.ytimg.com/vi/rnqW1fZxSyM/maxresdefault.jpg'),
('https://www.bettycrocker.lat/mx/wp-content/uploads/sites/2/2020/12/BCmexico-recipe-pastel-maravilla-de-chocolate.png');