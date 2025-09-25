-- reset.sql
-- Borrar todas las tablas del esquema público de psico_db

DROP TABLE IF EXISTS question_answers CASCADE;
DROP TABLE IF EXISTS questions CASCADE;
DROP TABLE IF EXISTS questionnaires CASCADE;
DROP TABLE IF EXISTS professional_diagnoses CASCADE;
DROP TABLE IF EXISTS predictions CASCADE;
DROP TABLE IF EXISTS reports CASCADE;
DROP TABLE IF EXISTS symptom_logs CASCADE;
DROP TABLE IF EXISTS goals CASCADE;
DROP TABLE IF EXISTS linked_profiles CASCADE;

-- Tablas de usuarios y roles (con relaciones)
DROP TABLE IF EXISTS user_profiles CASCADE;
DROP TABLE IF EXISTS user_roles CASCADE;
DROP TABLE IF EXISTS roles CASCADE;
DROP TABLE IF EXISTS users CASCADE;