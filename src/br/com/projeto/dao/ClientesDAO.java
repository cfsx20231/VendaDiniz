/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.model.Clientes;
import br.com.projeto.model.Fornecedor;
import br.projeto.jdbc.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ALEX
 */
public class ClientesDAO {

    private Connection con;

    public ClientesDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    public void cadastrarCliente(Clientes obj) {
        try {
            //escrever comando sql
            String sql = "insert into tb_clientes (nome, rg, cpf, email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado)"
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?);";

            //ORGANIZAR/Prepaarar O CODIGO SQL
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getCelular());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setInt(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getEstado());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "erro ao cadastrar" + err);
        }
    }

    public void excluirCliente(Clientes obj) {
        try {
            //escrever comando sql
            String sql = "delete from tb_clientes where id = ?";

            //ORGANIZAR/Prepaarar O CODIGO SQL
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId());
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso");

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "erro ao excluir" + err);
        }
    }

    public void alterarCliente(Clientes obj) {
        try {
            //escrever comando sql
            String sql = "update tb_clientes set nome=?, rg=?, cpf=?, email=?,telefone=?,celular=?,cep=?,endereco=?,numero=?,complemento=?,bairro=?,cidade=?,estado=? where id=?";

            //ORGANIZAR/Prepaarar O CODIGO SQL
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getCelular());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setInt(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getEstado());
            stmt.setInt(14, obj.getId());
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso");

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "erro ao alterar" + err);
        }
    }

    public List<Clientes> ListarClientes() {
        try {
            List<Clientes> lista = new ArrayList<>();

            String sql = "select * from tb_clientes";
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Clientes obj = new Clientes();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));

                lista.add(obj);
            }

            return lista;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "erro ao listar" + e);

            return null;
        }

    }

    public List<Clientes> buscaClienteNome(String nome) {
        try {
            List<Clientes> lista = new ArrayList<>();

            String sql = "select * from tb_clientes where nome like?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Clientes obj = new Clientes();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));

                lista.add(obj);
            }

            return lista;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "erro ao listar" + e);

            return null;
        }

    }

    public Clientes listarClientePorNomeTela(String nome) {
        try {

            String sql = "select * from tb_clientes where nome=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();
            Clientes obj = new Clientes();
            while (rs.next()) {
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));

            }
            return obj;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "erro ao listar" + e);

            return null;
        }

    }
    public Clientes listarClientePorCPFTela(String cpf) {
        try {

            String sql = "select * from tb_clientes where cpf=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cpf);

            ResultSet rs = stmt.executeQuery();
            Clientes obj = new Clientes();
            while (rs.next()) {
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));

            }
            return obj;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "erro ao listar" + e);

            return null;
        }

    }



}
