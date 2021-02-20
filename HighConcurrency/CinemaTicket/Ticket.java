package HighConcurrency.CinemaTicket;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 通过卖票程序读懂多线程--电影票的类
 *
 * @author zhuhuix
 * @date 2020-05-12
 */
public class Ticket {

    //id
    private int ticketId;
    //放映厅
    private String room;
    //行
    private Integer row;
    //列
    private Integer col;
    //电影名
    private String filmName;
    //价格
    private BigDecimal price;
    //放映时间
    private LocalDateTime datetime;

    private Ticket(){

    }

    public Ticket(int ticketId,String room, Integer row, Integer col, String filmName, BigDecimal price, LocalDateTime datetime) {
        this.ticketId = ticketId;
        this.room = room;
        this.row = row;
        this.col = col;
        this.filmName = filmName;
        this.price = price;
        this.datetime = datetime;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getCol() {
        return col;
    }

    public void setCol(Integer col) {
        this.col = col;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", room='" + room + '\'' +
                ", row=" + row +
                ", col=" + col +
                ", filmName='" + filmName + '\'' +
                ", price=" + price +
                ", datetime=" + datetime +
                '}';
    }
}
