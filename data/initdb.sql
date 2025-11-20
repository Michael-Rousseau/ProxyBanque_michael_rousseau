DELETE FROM client;
DELETE FROM advisor;

INSERT INTO advisor (id, first_name, last_name)
VALUES ('123e4567-e89b-12d3-a456-426614174000', 'John', 'Available');

INSERT INTO advisor (id, first_name, last_name)
VALUES ('222e4567-e89b-12d3-a456-426614174000', 'Sarah', 'Full');

INSERT INTO client (id, first_name, last_name, advisor_id) VALUES
                                                               ('a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a01', 'Client', '1', '222e4567-e89b-12d3-a456-426614174000'),
                                                               ('a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a02', 'Client', '2', '222e4567-e89b-12d3-a456-426614174000'),
                                                               ('a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a03', 'Client', '3', '222e4567-e89b-12d3-a456-426614174000'),
                                                               ('a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a04', 'Client', '4', '222e4567-e89b-12d3-a456-426614174000'),
                                                               ('a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a05', 'Client', '5', '222e4567-e89b-12d3-a456-426614174000'),
                                                               ('a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a06', 'Client', '6', '222e4567-e89b-12d3-a456-426614174000'),
                                                               ('a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a07', 'Client', '7', '222e4567-e89b-12d3-a456-426614174000'),
                                                               ('a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a08', 'Client', '8', '222e4567-e89b-12d3-a456-426614174000'),
                                                               ('a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a09', 'Client', '9', '222e4567-e89b-12d3-a456-426614174000'),
                                                               ('a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a10', 'Client', '10', '222e4567-e89b-12d3-a456-426614174000');