CREATE TABLE IF NOT EXISTS event (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    source TEXT NOT NULL,
    source_id TEXT NOT NULL,
    description jsonb,
    action TEXT NOT NULL,
    status TEXT NOT NULL,
    result TEXT,
    event_time TIMESTAMP NOT NULL
);

CREATE INDEX IF NOT EXISTS journal_source_source_id on event(source, source_id);