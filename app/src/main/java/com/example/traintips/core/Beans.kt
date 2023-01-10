package com.example.traintips.core

import java.util.Date

data class ConfigBean (
    var api_key: String
)

data class CoordBean (
    var lon :Double,
    var lat :Double
)

data class TrainTypeBean (
    var id :String,
    var label :String
)

data class StationBean (
    var id :String,
    var name :String,
    var city :CityBean,
    var location :CoordBean
)

data class CityBean (
    var id :String,
    var name :String,
    var location :CoordBean,
    var zip :Int
)

data class TrainBean (
    var id :String,
    var types :ArrayList<TrainTypeBean>
)

data class JourneyBean (
    var id :String,
    var train :TrainBean,
    var departure :StationBean,
    var arrival :StationBean,
    var departure_time :Date,
    var arrival_time :Date
)