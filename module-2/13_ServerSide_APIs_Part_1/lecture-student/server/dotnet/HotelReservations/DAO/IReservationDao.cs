using HotelReservations.Models;
using System.Collections.Generic;

namespace HotelReservations.DAO
{
    public interface IReservationDao
    {
        Reservation Create(Reservation reservation);
        List<Reservation> FindByHotel(int hotelId);
        Reservation Get(int id);
        List<Reservation> List();
    }
}