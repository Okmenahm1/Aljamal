package com.example.datastructerproject2;

public interface DBSTIF extends BTIF{
    Node find(String data);
    void insert(District data);
    void delete(District data);
}
