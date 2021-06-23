using System.Collections.Generic;
using HotelReservations.Models;

namespace HotelReservations.DAO
{
    public interface IHotelDao
    {
        List<Hotel> List();

        Hotel Get(int id);
    }
}
