package com.ansmeer.backendassignment3.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.tags.Tag;

@OpenAPIDefinition(
        info = @Info(
                title = "MovieDatabase API",
                version = "1.0",
                description = "Backend Assignment 3",
                license = @License(name = "MIT © 2023 ansmeer, MHavre")
        ),
        tags = {
                @Tag(name = "Character", description = "All endpoints related to characters"),
                @Tag(name = "Franchise", description = "All endpoints related to franchises"),
                @Tag(name = "Movie", description = "All endpoints related to movies"),
                @Tag(name = "Get", description = "All get endpoints"),
                @Tag(name = "Post", description = "All post endpoints"),
                @Tag(name = "Put", description = "All put endpoints"),
                @Tag(name = "Delete", description = "All delete endpoints")
        }
)
public class OpenApiConfig {
}