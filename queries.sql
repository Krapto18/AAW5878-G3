-- Ver usuarios
SELECT user_id, username, email FROM users;

-- Ver roles
SELECT * FROM roles;

-- Ver relaciones usuario-rol
SELECT u.username, r.role_name
FROM user_roles ur
         JOIN users u ON ur.user_id = u.user_id
         JOIN roles r ON ur.role_id = r.role_id;

-- Ver perfiles de usuario
SELECT u.username, p.full_name, p.date_of_birth, p.phone_number
FROM user_profiles p
         JOIN users u ON p.user_id = u.user_id;

-- Ver perfiles vinculados
SELECT t.username AS tutor, c.username AS child, prof.username AS professional, lp.status
FROM linked_profiles lp
         JOIN users t ON lp.tutor_id = t.user_id
         JOIN users c ON lp.child_id = c.user_id
         JOIN users prof ON lp.professional_id = prof.user_id;

-- Ver cuestionarios y preguntas
SELECT qn.title, qs.question_text
FROM questionnaires qn
         JOIN questions qs ON qn.questionnaire_id = qs.questionnaire_id;

-- Ver respuestas
SELECT u.username, qn.title, qs.question_text, qa.answer_value, qa.answered_at
FROM question_answers qa
         JOIN users u ON qa.user_id = u.user_id
         JOIN questions qs ON qa.question_id = qs.question_id
         JOIN questionnaires qn ON qs.questionnaire_id = qn.questionnaire_id;

-- Ver predicciones
SELECT u.username, p.prediction_score, p.explanation_text, p.predicted_at
FROM predictions p
         JOIN users u ON p.user_id = u.user_id;

-- Ver reportes
SELECT r.report_id, u1.username AS generado_por, u2.username AS para_usuario, r.file_path
FROM reports r
         JOIN users u1 ON r.generated_by_user_id = u1.user_id
         JOIN users u2 ON r.for_user_id = u2.user_id;

-- Ver diagnósticos profesionales
SELECT prof.username AS profesional, pac.username AS paciente, d.diagnosis_text
FROM professional_diagnoses d
         JOIN users prof ON d.professional_id = prof.user_id
         JOIN users pac ON d.patient_id = pac.user_id;
