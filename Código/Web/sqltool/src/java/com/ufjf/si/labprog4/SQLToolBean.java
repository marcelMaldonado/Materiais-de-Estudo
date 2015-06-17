package com.ufjf.si.labprog4;
// JavaBean para executar sql.

import java.sql.*;

public class SQLToolBean {

    private String sql = "";
    private String userName = "";
    private String password = "";
    private String connectionUrl = "jdbc:mysql://localhost/pgmc";

    public String getResult() {
        if (sql == null || sql.equals("")) {
            return "";
        }
        StringBuffer result = new StringBuffer(1024);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    connectionUrl, userName, password);
            Statement s = con.createStatement();
            if (getSql().toUpperCase().startsWith("SELECT")) {
                result.append("<TABLE BORDER=1>");
                ResultSet rs = s.executeQuery(getSql());
                ResultSetMetaData rsmd = rs.getMetaData();
                // Escreve o cabe�alho da tabela
                int columnCount = rsmd.getColumnCount();
                result.append("<TR>");
                for (int i = 1; i <= columnCount; i++) {
                    result.append("<TD><B>"
                            + rsmd.getColumnName(i) + "</B></TD>\n");
                }
                result.append("</TR>");
                while (rs.next()) {
                    result.append("<TR>");
                    for (int i = 1; i <= columnCount; i++) {
                        result.append("<TD>"
                                + encodeHtmlTag(rs.getString(i)) + "</TD>");
                    }
                    result.append("</TR>");
                }
            } else {
                int i = s.executeUpdate(sql);
                result.append("Records(s) affected:   " + i);
            }
            s.close();
            con.close();
            result.append("</TABLE>");
        } catch (SQLException e) {
            result.append("<B>SQL Error</B>");
            result.append("<BR>");
            result.append(e.toString());
        } catch (Exception e) {
            result.append("<B>Error</B>");
            result.append("<BR>");
            result.append(e.toString());
        }
        return result.toString();
    } // fim de getResult

    public static String encodeHtmlTag(String tag) {
        if (tag == null) {
            return null;
        }
        int length = tag.length();
        StringBuffer encodedTag = new StringBuffer(2 * length);
        for (int i = 0; i < length; i++) {
            char c = tag.charAt(i);
            if (c == '<') {
                encodedTag.append("&lt;");
            } else if (c == '>') {
                encodedTag.append("&gt;");
            } else if (c == '&') {
                encodedTag.append("&amp;");
            } else if (c == '"') {
                encodedTag.append("&quot;");
            } else if (c == ' ') {
                encodedTag.append("&nbsp;");
            } else {
                encodedTag.append(c);
            }
        }
        return encodedTag.toString();
    }

    public void setUserName(String name) {
        this.userName = name;
    }
    public void setPassword(String senha) {
        this.password = senha;
    }
    public void setSql(String sql) {
        this.sql = sql;
    }
    
    public String getuserName(){
        return userName;
    }
    public String getPassword(){
        return password;
    }
    public String getSql(){
        return sql;
    }
} // fim da classe SQLToolBean

