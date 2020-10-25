insert into tb_usuario values(USUARIO_SEQ.nextval, 'joao@gmail.com', 'João', '123123');
insert into tb_usuario values(USUARIO_SEQ.nextval, 'maria@gmail.com', 'Maria', '123123');
insert into tb_usuario values(USUARIO_SEQ.nextval, 'pedro@gmail.com', 'Pedro', '123123');

insert into tb_chamado(id_chamado, descricao_chamado, id_promotor_chamado, protocolo_chamado, status_chamado, titulo_chamado, id_usuario) values(CHAMADO_SEQ.nextval, 'Descrição chamado aberto no1', 1,  111111, 'aberto', 'Chamado aberto no1', 1);
insert into tb_chamado(id_chamado, descricao_chamado, id_promotor_chamado, protocolo_chamado, status_chamado, titulo_chamado, id_usuario) values(CHAMADO_SEQ.nextval, 'Descrição chamado aberto no2', 1,  111112, 'aberto', 'Chamado aberto no2', 2); 
insert into tb_chamado(id_chamado, descricao_chamado, id_promotor_chamado, protocolo_chamado, status_chamado, titulo_chamado, id_usuario) values(CHAMADO_SEQ.nextval, 'Descrição chamado aberto no3', 1,  111113, 'aberto', 'Chamado aberto no3', 3);
insert into tb_chamado(id_chamado, descricao_chamado, id_promotor_chamado, protocolo_chamado, status_chamado, titulo_chamado, id_usuario) values(CHAMADO_SEQ.nextval, 'Descrição chamado aberto no4', 1,  111114, 'aberto', 'Chamado aberto no4', 1);
 
insert into tb_chamado values(CHAMADO_SEQ.nextval, 'Descrição chamado aguardando resposta no1',1, 5, 111224, 'aguardando','Chamado aguardando resposta no1', 1);
insert into tb_chamado values(CHAMADO_SEQ.nextval, 'Descrição chamado aguardando resposta no2',1, 5, 111225, 'aguardando','Chamado aguardando resposta no2', 2);
insert into tb_chamado values(CHAMADO_SEQ.nextval, 'Descrição chamado aguardando resposta no3',1, 5, 111226, 'aguardando','Chamado aguardando resposta no3', 3);

insert into tb_chamado values(CHAMADO_SEQ.nextval, 'Descrição chamado fechado no1', 1, 5, 111227, 'fechado', 'Chamado fechado no1', 1);
insert into tb_chamado values(CHAMADO_SEQ.nextval, 'Descrição chamado fechado no2', 1, 5, 111228, 'fechado', 'Chamado fechado no2', 3);