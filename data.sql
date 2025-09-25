-- 1. Insertar usuarios
INSERT INTO users (user_id, username, email, password_hash)
VALUES
    (gen_random_uuid(), 'jose123', 'jose@example.com', 'hashed_pass_1'),
    (gen_random_uuid(), 'maria456', 'maria@example.com', 'hashed_pass_2'),
    (gen_random_uuid(), 'pedro789', 'pedro@example.com', 'hashed_pass_3');

-- 2. Insertar roles
INSERT INTO roles (role_name)
VALUES
    ('Admin'),
    ('Psicologo'),
    ('Paciente');

-- 3. Relacionar usuarios con roles
INSERT INTO user_roles (user_id, role_id)
SELECT u.user_id,
       CASE u.username
           WHEN 'jose123'  THEN (SELECT role_id FROM roles WHERE role_name = 'Admin')
           WHEN 'maria456' THEN (SELECT role_id FROM roles WHERE role_name = 'Paciente')
           WHEN 'pedro789' THEN (SELECT role_id FROM roles WHERE role_name = 'Psicologo')
           END
FROM users u;

-- 4. Insertar perfiles de usuarios
INSERT INTO user_profiles (profile_id, user_id, full_name, date_of_birth, phone_number)
SELECT gen_random_uuid(), u.user_id,
       CASE u.username
           WHEN 'jose123'  THEN 'José Pérez'
           WHEN 'maria456' THEN 'María López'
           WHEN 'pedro789' THEN 'Pedro Ramírez'
           END AS full_name,
       CASE u.username
           WHEN 'jose123'  THEN '1995-04-12'
           WHEN 'maria456' THEN '1998-09-22'
           WHEN 'pedro789' THEN '1992-11-05'
           END::DATE AS date_of_birth,
       CASE u.username
           WHEN 'jose123'  THEN '987654321'
           WHEN 'maria456' THEN '999888777'
           WHEN 'pedro789' THEN '911222333'
           END AS phone_number
FROM users u;
