package org.shams.phonebook.domain.impl;

import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author <a href="mailto:m.h.shams@gmail.com">M. H. Shamsi</a>
 * @version 1.0.0
 *          Date Oct 17, 2007
 */

@SuppressWarnings({"JpaDataSourceORMInspection"})
@Entity
@Table(name = "_USER")
public class User extends DomainObjectImpl implements UserDetails {
    private transient static final String DEFAULT_USER_ROLE = "ROLE_USER";

    @Column(name = "NAME")
    private String name;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    public User() {
    }

    public User(long id, String name, String username, String password) {
        setId(id);
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public GrantedAuthority[] getAuthorities() {
        return new GrantedAuthority[]{
                new GrantedAuthority() {
                    public String getAuthority() {
                        return DEFAULT_USER_ROLE;
                    }
                }
        };
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
