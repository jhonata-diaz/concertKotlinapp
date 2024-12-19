package com.thejebereal.thejeberealapp.domain.repository

import com.thejebereal.thejeberealapp.core.Concert
import com.thejebereal.thejeberealapp.core.TicketConcert


// Data class para conciertos
// Interface para el API
//REPOSITORY
interface ConcertApi {
    suspend fun getPopularConcerts(): List<Concert>
    suspend fun getBestOffersConcerts(): List<Concert>
    suspend fun getCalendarConcerts(): List<Concert>
    suspend fun getConcertDetails(id: String): Concert
    suspend fun getTicketsForConcert(concertId: String): List<TicketConcert> // Nuevo método
    suspend fun updateTicketAvailability(ticketId: String, isAvailable: Boolean)
    suspend fun createTransaction(
        userId: String,
        concertId: String,
        ticketId: String,
        amount: Double,
        date: String
    ): String

}
