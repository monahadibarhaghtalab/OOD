package data.entities.entityfile;

import org.hibernate.annotations.Type;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.UUID;

/**
 * Created by Mona on 5/9/2015.
 */
public class MessageEntityR extends MessageEntity {
    private UserEntity userSender;
    private UserEntity userReceiver;

    private UUID userIdSender;
    private UUID userIdReceiver;


    @Column(name = "UserIdSender",
            nullable = false)
    @Type(type = "uuid-binary")
    @Basic
    public UUID getUserIdSender() {
        return userIdSender;
    }

    public void setUserIdSender(UUID userId) {
        this.userIdSender = userId;
    }

    @ManyToOne
    @JoinColumn(name = "UserIdSender",
            referencedColumnName = "Guid",
            updatable = true,
            insertable = true,
            nullable = false)
    public UserEntity getUserSender() {
        return userSender;
    }

    public void setUserSender(UserEntity userSender) {
        this.userSender = userSender;
    }


    public UserEntity getUserReceiver() {
        return userReceiver;
    }

    public void setUserReceiver(UserEntity userSender) {
        this.userReceiver = userReceiver;
    }
}
