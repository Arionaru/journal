package com.example.journal.domain;

import com.example.journalapi.domain.Source;
import com.example.journalapi.domain.Status;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
@Entity
@Builder
@TypeDef(
        name = "jsonb",
        typeClass = JsonBinaryType.class
)
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private Source source;

    private String sourceId;

    @Type(type = "jsonb")
    private Map<String, Object> description;

    private String action;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String result;

    private LocalDateTime eventTime;
}
