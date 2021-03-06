PGDMP                          x            shelter    12.1    12.0     B           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            C           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            D           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            E           1262    17628    shelter    DATABASE     e   CREATE DATABASE shelter WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'C' LC_CTYPE = 'C';
    DROP DATABASE shelter;
                postgres    false            �            1259    17631    pets    TABLE     �   CREATE TABLE public.pets (
    id integer NOT NULL,
    name text,
    gender integer,
    breed text,
    height numeric,
    weight numeric
);
    DROP TABLE public.pets;
       public         heap    postgres    false            �            1259    17629    pets_id_seq    SEQUENCE     �   CREATE SEQUENCE public.pets_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.pets_id_seq;
       public          postgres    false    203            F           0    0    pets_id_seq    SEQUENCE OWNED BY     ;   ALTER SEQUENCE public.pets_id_seq OWNED BY public.pets.id;
          public          postgres    false    202            �           2604    17634    pets id    DEFAULT     b   ALTER TABLE ONLY public.pets ALTER COLUMN id SET DEFAULT nextval('public.pets_id_seq'::regclass);
 6   ALTER TABLE public.pets ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    202    203    203            ?          0    17631    pets 
   TABLE DATA           G   COPY public.pets (id, name, gender, breed, height, weight) FROM stdin;
    public          postgres    false    203   4
       G           0    0    pets_id_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.pets_id_seq', 6, true);
          public          postgres    false    202            �           2606    17639    pets pets_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.pets
    ADD CONSTRAINT pets_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.pets DROP CONSTRAINT pets_pkey;
       public            postgres    false    203            ?   '   x�3��,)-�4�,����/��4�3�г����� ��     