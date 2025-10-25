package pe.edu.upc.kidtd.Securities;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class swagger {
    // Define un nombre para el esquema de seguridad
    private static final String SCHEME_NAME = "bearerAuth";

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                // 1. Define el componente de seguridad
                .components(new Components()
                        .addSecuritySchemes(SCHEME_NAME, new SecurityScheme()
                                .name(SCHEME_NAME)
                                .type(SecurityScheme.Type.HTTP) // Indica que usa el encabezado HTTP
                                .scheme("bearer")             // Especifica que es un token "Bearer"
                                .bearerFormat("JWT")          // Opcional, para documentación
                                .in(SecurityScheme.In.HEADER) // Se envía en el encabezado
                        )
                )
                // 2. Aplica el requisito de seguridad globalmente (si todos los endpoints lo necesitan)
                .addSecurityItem(new SecurityRequirement().addList(SCHEME_NAME));
    }
}
