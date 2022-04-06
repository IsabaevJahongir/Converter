INSERT INTO public.roles(id, name)
VALUES (1, 'ROLE_USER'), (2, 'ROLE_ADMIN');

INSERT INTO public.users(id, username, password)
VALUES (1, 'ADMIN', 'ADMIN');

INSERT INTO public.users_roles(user_id, roles_id)
VALUES (1, 2);