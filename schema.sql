-- 1. Tabla principal: USERS
CREATE TABLE users (
                       user_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                       username VARCHAR(255) UNIQUE NOT NULL,
                       email VARCHAR(255) UNIQUE NOT NULL,
                       password_hash VARCHAR(255) NOT NULL,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 2. ROLES
CREATE TABLE roles (
                       role_id SERIAL PRIMARY KEY,
                       role_name VARCHAR(50) UNIQUE NOT NULL
);

-- 3. USER_ROLES (relación muchos a muchos entre users y roles)
CREATE TABLE user_roles (
                            user_id UUID REFERENCES users(user_id),
                            role_id INT REFERENCES roles(role_id),
                            PRIMARY KEY (user_id, role_id)
);

-- 4. USER_PROFILES (1 a 1 con users)
CREATE TABLE user_profiles (
                               profile_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                               user_id UUID UNIQUE REFERENCES users(user_id),
                               full_name VARCHAR(255),
                               date_of_birth DATE,
                               phone_number VARCHAR(20)
);

-- 5. LINKED_PROFILES (usuarios relacionados)
CREATE TABLE linked_profiles (
                                 link_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                 tutor_id UUID REFERENCES users(user_id),
                                 child_id UUID REFERENCES users(user_id),
                                 professional_id UUID REFERENCES users(user_id),
                                 status VARCHAR(50) DEFAULT 'pending'
);

-- 6. QUESTIONNAIRES
CREATE TABLE questionnaires (
                                questionnaire_id SERIAL PRIMARY KEY,
                                title VARCHAR(255) NOT NULL,
                                version_number INT NOT NULL
);

-- 7. QUESTIONS
CREATE TABLE questions (
                           question_id SERIAL PRIMARY KEY,
                           questionnaire_id INT REFERENCES questionnaires(questionnaire_id),
                           question_text TEXT NOT NULL
);

-- 8. QUESTION_ANSWERS
CREATE TABLE question_answers (
                                  answer_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                  user_id UUID REFERENCES users(user_id),
                                  question_id INT REFERENCES questions(question_id),
                                  answer_value INT,
                                  answered_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 9. PREDICTIONS
CREATE TABLE predictions (
                             prediction_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                             user_id UUID REFERENCES users(user_id),
                             prediction_score DECIMAL(5, 2) NOT NULL,
                             explanation_text TEXT,
                             predicted_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 10. SYMPTOM_LOGS
CREATE TABLE symptom_logs (
                              log_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                              user_id UUID REFERENCES users(user_id),
                              mood_entry VARCHAR(50),
                              symptom_notes TEXT,
                              log_date DATE NOT NULL
);

-- 11. GOALS
CREATE TABLE goals (
                       goal_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                       user_id UUID REFERENCES users(user_id),
                       goal_description TEXT NOT NULL,
                       start_date DATE,
                       end_date DATE,
                       status VARCHAR(50) DEFAULT 'in_progress'
);

-- 12. REPORTS
CREATE TABLE reports (
                         report_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                         generated_by_user_id UUID REFERENCES users(user_id),
                         for_user_id UUID REFERENCES users(user_id),
                         start_date DATE,
                         end_date DATE,
                         file_path VARCHAR(255),
                         generated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 13. PROFESSIONAL_DIAGNOSES
CREATE TABLE professional_diagnoses (
                                        diagnosis_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                        professional_id UUID REFERENCES users(user_id),
                                        patient_id UUID REFERENCES users(user_id),
                                        diagnosis_text TEXT NOT NULL,
                                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
