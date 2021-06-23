﻿using HotelReservations.Models;
using System;
using System.Collections.Generic;
using System.Linq;

namespace HotelReservations.DAO
{
    public class ReservationDao : IReservationDao
    {
        // each request of the controller creates a new instance of the DAO
        // this is to preserve the data on each request until we get to dependency injection
        private static List<Reservation> Reservations { get; set; }

        public ReservationDao()
        {
            if (Reservations == null)
            {
                Reservations = new List<Reservation>
                {
                    new Reservation(1, 1, "John Smith", DateTime.Today.ToString(), DateTime.Today.AddDays(3).ToString(), 2),
                    new Reservation(2, 1, "Sam Turner", DateTime.Today.ToString(), DateTime.Today.AddDays(5).ToString(), 4),
                    new Reservation(3, 1, "Mark Johnson", DateTime.Today.AddDays(7).ToString(), DateTime.Today.AddDays(10).ToString(), 2),
                    new Reservation(4, 2, "Jospeh Williams", DateTime.Today.AddDays(2).ToString(), DateTime.Today.AddDays(4).ToString(), 2)
                };
            }
        }

        public List<Reservation> List()
        {
            return Reservations;
        }

        public Reservation Get(int id)
        {
            foreach (var reservation in Reservations)
            {
                if (reservation.Id == id)
                {
                    return reservation;
                }
            }

            return null;
        }

        public List<Reservation> FindByHotel(int hotelId)
        {
            List<Reservation> matched = new List<Reservation>();
            foreach (Reservation r in Reservations)
            {
                if (r.HotelId == hotelId)
                {
                    matched.Add(r);
                }
            }
            return matched;
        }

        public Reservation Create(Reservation reservation)
        {
            int maxId = Reservations.Max(r => r.Id) ?? 0;
            reservation.Id = maxId + 1;
            Reservations.Add(reservation);
            return reservation;
        }
    }
}
