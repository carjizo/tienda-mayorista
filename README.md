# API-spring-boot
Se tiene una tienda mayorista de productos comestibles. 

Cada **producto** tiene un nombre o descripción, un código interno, una unidad de medida (unidad, bolsa, caja, etc) una categoría (bebida, galleta, chocolate, miscelánea, etc.), un conjunto de proveedores, además de ello tienen fechas de vencimiento no necesariamente el mismo para cada producto. 
Cada  **proveedor** tiene una razón social, un RUC, una dirección o domicilio fiscal y una serie de productos comestibles que distribuyen (Muchos proveedores pueden comercializar un producto y un proveedor puede comercializar muchos productos).
Los **clientes** tienen los siguientes atributos: Nombre, dirección, teléfono, DNI/RUC. 
Las **ventas y compras** se hacen en **facturas** que tienen los campos: fecha y hora de pedido, número de serie y número de factura, cliente/proveedor y los detalles de las compras/ventas que son las líneas de pedido. Ahora, todos los productos adquiridos se guardan en un almacén donde se tiene un registro del **stock** (producto, cantidad, fecha vencimiento
