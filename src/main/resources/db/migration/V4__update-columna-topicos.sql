ALTER TABLE topicos
ADD COLUMN fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP;

UPDATE topicos
SET fecha_creacion = CURRENT_TIMESTAMP
WHERE fecha_creacion IS NULL;

