INSERT INTO public.material (id, name, alias) VALUES (1, 'rice', '大白米');
INSERT INTO public.material (id, name, alias) VALUES (3, 'garlic', '蒜');
INSERT INTO public.material (id, name, alias) VALUES (4, 'salt', '盐');
INSERT INTO public.material (id, name, alias) VALUES (5, 'egg', '蛋');
INSERT INTO public.material (id, name, alias) VALUES (2, 'pork belly', '五花肉');

INSERT INTO public.disk (id, description, img, name) VALUES (1, '肥而不腻的红烧肉', '', '红烧肉');
INSERT INTO public.disk (id, description, img, name) VALUES (2, '米其林级别的炒饭', '', '蛋炒饭');

INSERT INTO public.disk_material(disk_id, material_id) VALUES (1, 2);
INSERT INTO public.disk_material(disk_id, material_id) VALUES (1, 3);
INSERT INTO public.disk_material(disk_id, material_id) VALUES (1, 4);

INSERT INTO public.disk_material(disk_id, material_id) VALUES (2, 5);
INSERT INTO public.disk_material(disk_id, material_id) VALUES (2, 1);
INSERT INTO public.disk_material(disk_id, material_id) VALUES (2, 4);