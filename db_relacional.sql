-------------------------------------------------
--tabla entidad TIPO_PLAN--
create table actividades.TIPO_PLAN
(
    ID          serial       not null,
    NOMBRE      varchar(150) not null,
    DESCRIPCION varchar(400) not null,
    constraint TIPO_PLAN_pkey primary key (ID)
);
-------------------------------------------------
--tabla entidad RESTRICCION--
create table actividades.RESTRICCION
(
    ID          serial       not null,
    NOMBRE      varchar(150) not null,
    DESCRIPCION varchar(400) not null,
    EDAD_MINIMA int          not null,
    EDAD_MAXIMA int          not null,
    constraint RESTRICCION_pkey primary key (ID)
);
-------------------------------------------------
--tabla intermedia para relacionar TIPO_PLAN - RESTRICCION--
create table actividades.TIPO_PLAN_REGISTRO
(
    ID             serial not null,
    ID_TIPO_PLAN   int    not null,
    ID_RESTRICCION int    not null,
    constraint TIPO_PLAN_REGISTRO_pkey primary key (ID),
    constraint ID_TIPO_PLAN_fkey foreign key (ID_TIPO_PLAN) references actividades.TIPO_PLAN,
    constraint ID_RESTRICCION_fkey foreign key (ID_RESTRICCION) references actividades.RESTRICCION
);
-------------------------------------------------
--tabla entidad UBICACION--
create table actividades.UBICACION
(
    ID            serial       not null,
    NOMBRE        varchar(150) not null,
    LATITUD       float        not null,
    LONGITUD      float        not null,
    MUNICIPIO     varchar(150) not null,
    DEPARTAMENTO  varchar(150) not null,
    PAIS          varchar(150) not null,
    FECH_REGISTRO date         not null,
    constraint UBICACION_pkey primary key (ID)
);
-------------------------------------------------
--tabla entidad PLAN--
create table actividades.PLAN
(
    ID            serial       not null,
    ID_UBICACION  int          not null,
    ID_ADJUNTO    int          not null,
    NOMBRE        varchar(150) not null,
    DESCRIPCION   varchar(400) not null,
    PRECIO_DIA    int          not null,
    CAPACIDAD     int          not null,
    FECH_REGISTRO date         not null,
    ACTIVO        bool         not null,
    constraint PLAN_pkey primary key (ID),
    constraint UBICACION_fkey foreign key (ID_UBICACION) references actividades.UBICACION
);
-------------------------------------------------
--tabla intermedia para relacionar PLAN - TIPO_PLAN--
create table actividades.DETALLE_TIPO_PLAN
(
    ID           serial not null,
    ID_PLAN      int    not null,
    ID_TIPO_PLAN int    not null,
    constraint DETALLE_TIPO_PLAN_pkey primary key (ID),
    constraint ID_TIPO_PLAN_fkey foreign key (ID_TIPO_PLAN) references actividades.TIPO_PLAN,
    constraint ID_PLAN_fkey foreign key (ID_PLAN) references actividades.PLAN
);
-------------------------------------------------
--tabla entidad RESERVA--
create table actividades.RESERVA
(
    ID                serial not null,
    ID_PLAN           int    not null,
    ID_USUARIO        int    not null,
    CANTIDAD_PERSONAS int    not null,
    FECH_REGISTRO     date   not null,
    FECH_DESDE        date   not null,
    FECH_HASTA        date   not null,
    constraint RESERVA_pkey primary key (ID),
    constraint PLAN_fkey foreign key (ID_PLAN) references actividades.PLAN
);