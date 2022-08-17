-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-08-2022 a las 08:59:05
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `omicrondb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id_Cliente` int(4) NOT NULL,
  `razonSocial` varchar(50) NOT NULL,
  `telefono` varchar(10) NOT NULL,
  `celular` varchar(10) DEFAULT NULL,
  `correo` varchar(40) DEFAULT NULL,
  `direccion` varchar(100) NOT NULL,
  `tipoIdentificacion` varchar(20) NOT NULL,
  `identificacion` varchar(10) NOT NULL,
  `tipoCliente` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id_Cliente`, `razonSocial`, `telefono`, `celular`, `correo`, `direccion`, `tipoIdentificacion`, `identificacion`, `tipoCliente`) VALUES
(1, 'ClientePrueba', '2105020', '2050602030', 'prueba@gmail.com', 'Loja, esquina', 'RUC', '1100604758', 'MINORISTA'),
(2, 'Diego Marquez', '2306050', '0908060502', 'diego@gmail.com', 'Loja', 'RUC', '1100338993', 'MINORISTA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallefactura`
--

CREATE TABLE `detallefactura` (
  `id` int(50) NOT NULL,
  `id_factura` int(50) NOT NULL,
  `id_cliente` int(50) NOT NULL,
  `fechaEmision` varchar(20) NOT NULL,
  `id_venta` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `detallefactura`
--

INSERT INTO `detallefactura` (`id`, `id_factura`, `id_cliente`, `fechaEmision`, `id_venta`) VALUES
(1, 1, 1, '2022/08/15', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_ventas`
--

CREATE TABLE `detalle_ventas` (
  `idDetalleVentas` int(11) NOT NULL,
  `idVentas` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precioVenta` double UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `detalle_ventas`
--

INSERT INTO `detalle_ventas` (`idDetalleVentas`, `idVentas`, `idProducto`, `cantidad`, `precioVenta`) VALUES
(1, 1, 30, 2, 25);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipo`
--

CREATE TABLE `equipo` (
  `id_equipo` int(4) NOT NULL,
  `razon_social` varchar(50) NOT NULL,
  `tipo_equipo` enum('COMPUTADOR','IMPRESORA') NOT NULL,
  `marca` varchar(15) NOT NULL,
  `modelo` varchar(15) NOT NULL,
  `cargador` varchar(10) NOT NULL,
  `estado_ingreso` varchar(60) NOT NULL,
  `descripcion_problema` varchar(60) NOT NULL,
  `precio_servicio` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `equipo`
--

INSERT INTO `equipo` (`id_equipo`, `razon_social`, `tipo_equipo`, `marca`, `modelo`, `cargador`, `estado_ingreso`, `descripcion_problema`, `precio_servicio`) VALUES
(1, '1100607458', 'COMPUTADOR', 'Dell', 'Inspiron 15', 'Si tiene', 'Cambio Bateria', 'Cambio Pantalla y Bisagras', 100);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE `factura` (
  `id` int(20) NOT NULL,
  `nombreEmpresa` varchar(50) NOT NULL,
  `ruc` varchar(13) NOT NULL,
  `codigoFactura` varchar(10) NOT NULL,
  `codigoAutorizacion` varchar(10) NOT NULL,
  `direccionEmpresa` varchar(50) NOT NULL,
  `telefonoEmpresa` varchar(10) NOT NULL,
  `emailEmpresa` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `factura`
--

INSERT INTO `factura` (`id`, `nombreEmpresa`, `ruc`, `codigoFactura`, `codigoAutorizacion`, `direccionEmpresa`, `telefonoEmpresa`, `emailEmpresa`) VALUES
(1, 'OMICRON TECNOLOGIA', '1105993198001', '1', '001', 'La Pradera, calle Alamos 235-16 y Catamayo', '072102085', 'omicrontec1@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL,
  `codigo` int(11) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `precioCompra` double NOT NULL,
  `precioVenta` double NOT NULL,
  `Proveedor` varchar(30) NOT NULL,
  `unidades` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`idProducto`, `codigo`, `nombre`, `descripcion`, `precioCompra`, `precioVenta`, `Proveedor`, `unidades`) VALUES
(1, 30, 'Teclado', 'Genius negro', 20, 25, 'Razon social: MACHALA DISTRI', 18),
(2, 8296, 'Parlante', 'Samsuns 80 Watts', 100, 140, 'Razon social: LOJA EMPRESA', 20),
(3, 732, 'Monitor', 'Asus 24 pulgadas', 250, 300, 'Razon social: LOJA EMPRESA', 10),
(4, 7089, 'Laptop', 'Dell 14 pulgadas i5', 300, 420, 'Razon social: MACHALA DISTRI', 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `id_Proveedor` int(4) NOT NULL,
  `agente_responsable` varchar(30) NOT NULL,
  `provincia` varchar(30) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `identificacion` varchar(13) NOT NULL,
  `razonSocial` varchar(30) NOT NULL,
  `telefono` varchar(10) NOT NULL,
  `celular` varchar(10) NOT NULL,
  `telefono_opcional` varchar(10) NOT NULL,
  `correo` varchar(40) NOT NULL,
  `pagina_web` varchar(50) NOT NULL,
  `banco` varchar(30) NOT NULL,
  `tipocuenta` varchar(20) NOT NULL,
  `nro_cuenta` varchar(20) NOT NULL,
  `credito` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Tabla para registro de proveedores';

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`id_Proveedor`, `agente_responsable`, `provincia`, `direccion`, `identificacion`, `razonSocial`, `telefono`, `celular`, `telefono_opcional`, `correo`, `pagina_web`, `banco`, `tipocuenta`, `nro_cuenta`, `credito`) VALUES
(3, 'PruebaProovedor', 'Loja', 'Loja', '1100445500001', 'LOJA EMPRESA', '2102050', '0905600402', '0603050405', 'pruebaproveedor@gmail.com', 'www.pruebaloja.com', 'Banco Solidario', 'Corriente', '2030506020', 'Aplica'),
(4, 'Juan Astudillo', 'El Oro', 'Machala', '1100335566001', 'MACHALA DISTRI', '2306050', '0906050300', '2306050', 'machala@gmail.com', 'www.distrimachala.com', 'Banco Internacional', 'Ahorros', '2233665522', 'No aplica');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `razonSocial` varchar(50) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `celular` varchar(10) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `direccion` varchar(20) NOT NULL,
  `tipoIdentificacion` varchar(10) NOT NULL,
  `identificacion` varchar(50) NOT NULL,
  `tipoRol` varchar(20) NOT NULL,
  `nombreUsuario` varchar(50) NOT NULL,
  `contrasena` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `razonSocial`, `telefono`, `celular`, `correo`, `direccion`, `tipoIdentificacion`, `identificacion`, `tipoRol`, `nombreUsuario`, `contrasena`) VALUES
(1, 'admin', '2102085', '0968832764', 'admin@gmail.com', 'Loja', 'CEDULA', '1105993198', 'ADMINISTRADOR', 'admin', 'admin'),
(2, 'Juan Chuquimarca', '2303536', '0965656478', 'jchuqui@gmail.com', 'San Pedro', 'CEDULA', '1150348744', 'VENDEDOR', 'Jchuqui', '12345');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `id_Venta` int(4) NOT NULL,
  `id_Cliente` int(4) NOT NULL,
  `nroSerie` varchar(10) NOT NULL,
  `fechaVenta` varchar(20) NOT NULL,
  `monto` double UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`id_Venta`, `id_Cliente`, `nroSerie`, `fechaVenta`, `monto`) VALUES
(1, 1, '0000001', '2022-8-15', 56);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_Cliente`);

--
-- Indices de la tabla `detallefactura`
--
ALTER TABLE `detallefactura`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `detalle_ventas`
--
ALTER TABLE `detalle_ventas`
  ADD PRIMARY KEY (`idDetalleVentas`),
  ADD KEY `idVentas` (`idVentas`);

--
-- Indices de la tabla `equipo`
--
ALTER TABLE `equipo`
  ADD PRIMARY KEY (`id_equipo`);

--
-- Indices de la tabla `factura`
--
ALTER TABLE `factura`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idProducto`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`id_Proveedor`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`id_Venta`),
  ADD UNIQUE KEY `nroSerie` (`nroSerie`),
  ADD KEY `id_Cliente` (`id_Cliente`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id_Cliente` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `detallefactura`
--
ALTER TABLE `detallefactura`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `detalle_ventas`
--
ALTER TABLE `detalle_ventas`
  MODIFY `idDetalleVentas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `equipo`
--
ALTER TABLE `equipo`
  MODIFY `id_equipo` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `factura`
--
ALTER TABLE `factura`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `id_Proveedor` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `id_Venta` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
