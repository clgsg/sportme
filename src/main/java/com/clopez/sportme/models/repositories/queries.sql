
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

-- createActivity
INSERT INTO ACTIVIDADES A ( FK_USUARIO, FK_DEPORTE, FK_INSTALACION, FECHA, COMENTARIOS)
VALUES (:idUsuario, :idDeporte, :idInstalacion, :fecha, :comentarios);



--------------- USERS ------------------

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


-- getParticipantNicks
select u.APODO
from usuarios u
join PARTICIPANTES p on p.FK_USUARIO= u.ID_USUARIO
join ACTIVIDADES a on a.ID_ACTIVIDAD = p.FK_ACTIVIDAD
where a.ID_ACTIVIDAD = :idActividad;
