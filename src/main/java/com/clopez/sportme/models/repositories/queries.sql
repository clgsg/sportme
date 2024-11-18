
-- getAllActivities
select d.DEPORTE, a.FECHA, i.NOMBRE from ACTIVIDADES a 
JOIN DEPORTES d on d.ID_DEPORTE= a.FK_DEPORTE
join INSTALACIONES i on i.ID_INSTALACION = a.FK_INSTALACION
and a.FECHA > SYSDATE;

-- getActivitiesByTypeAndDate
select d.DEPORTE, a.FECHA, i.NOMBRE from ACTIVIDADES a 
JOIN DEPORTES d on d.ID_DEPORTE= a.FK_DEPORTE
join INSTALACIONES i on i.ID_INSTALACION = a.FK_INSTALACION
where d.deporte = :deporte and a.fecha= :fecha;

-- getActivitiesByType
select d.DEPORTE, a.FECHA, i.NOMBRE from ACTIVIDADES a 
JOIN DEPORTES d on d.ID_DEPORTE= a.FK_DEPORTE
join INSTALACIONES i on i.ID_INSTALACION = a.FK_INSTALACION
where d.deporte = :deporte
and a.FECHA > SYSDATE ;

-- getActivitiesByDate
select d.DEPORTE, a.FECHA, i.NOMBRE from ACTIVIDADES a 
JOIN DEPORTES d on d.ID_DEPORTE= a.FK_DEPORTE
join INSTALACIONES i on i.ID_INSTALACION = a.FK_INSTALACION
where a.fecha= :fecha;

-- getActivitiesCreatedByUser
select d.DEPORTE, a.FECHA, i.NOMBRE from ACTIVIDADES a 
JOIN DEPORTES d on d.ID_DEPORTE= a.FK_DEPORTE
join INSTALACIONES i on i.ID_INSTALACION = a.FK_INSTALACION
where a.fk_usuario = :idUsuario
or a.fk_usuario= (select id_usuario from USUARIOS where apodo= :apodo)
and a.FECHA > sysdate;

-- countParticipants
select COUNT(*)
from usuarios u
join PARTICIPANTES p on p.FK_USUARIO= u.ID_USUARIO
join ACTIVIDADES a on a.ID_ACTIVIDAD = p.FK_ACTIVIDAD
group by a.ID_ACTIVIDAD
having a.ID_ACTIVIDAD = :idActividad;

-- createActividad
INSERT INTO ACTIVIDADES A ( FK_USUARIO, FK_DEPORTE, FK_INSTALACION, FECHA, COMENTARIOS)
VALUES (:idUsuario, :idDeporte, :idInstalacion, :fecha, :comentarios);



--------------- USERS ------------------
-- getDataUsuarioById
select u.apodo, u.nombre, u.apellido1, u.apellido2, c.correo from USUARIOS U 
join CORREOS c on c.fk_usuario = u.id_usuario
where u.id_usuario = :idUsuario;


-- getAllUsers
select * from USUARIOS;

-- getUserById
select * from USUARIOS
where ID_USUARIO= :idUsuario;

-- getUserByApodo
SELECT * from USUARIOS
where APODO= LOWER(:apodo);

-- getApodoById
SELECT apodo from USUARIOS
where ID_USUARIO= :idUsuario;

-- getUserFirstNameById (greetings)
select u.nombre
from USUARIOS u
where u.ID_USUARIO= :idUsuario;

-- getMailByApodo
select c.correo from CORREOS c
where c.FK_USUARIO = (select id_usuario from USUARIOS where apodo= LOWER(:apodo));

-- getMailById
select c.correo from CORREOS c
where c.FK_USUARIO = :idUsuario ;

-- newUsuario
INSERT INTO USUARIOS (apodo, nombre, APELLIDO1, APELLIDO2)
VALUES (:apodo, :nombre, :apellido1, :apellido2);

-- getParticipantNicks
select u.APODO
from usuarios u
join PARTICIPANTES p on p.FK_USUARIO= u.ID_USUARIO
join ACTIVIDADES a on a.ID_ACTIVIDAD = p.FK_ACTIVIDAD
where a.ID_ACTIVIDAD = :idActividad;


--- getCorreoByUserIdOrNick
select c.correo 
from CORREOS c
where c.fk_usuario = :idUsuario;
-- updateCorreoUsuario
update CORREOS
set correo = :nuevoCorreo
where fk_usuario=:id_usuario;

-- addCorreoUsuario
insert into CORREOS (fk_usuario, correo)
values (:idUsuario, :correo);



---- getDireccionInstalacion
select i.TIPO_VIA, i.NOMBRE_VIA, i.NUM_VIA
from INSTALACIONES i where i.ID_INSTALACION=:idInstalacion;


select tipo from TIPOS_INSTALACION where id_tipo=:idTipoInstalacion;
