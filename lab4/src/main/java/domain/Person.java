/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Profesor Lic. Gilberth Chaves A.
 */
public interface Person {
    public boolean equals(Person other);
    public String getName();
    public int getAge();
    public String getAddress();
}
