package io.twodigits.demo.groundoperations.taxi

import io.twodigits.demo.groundoperations.thirdparty.Plane
import org.springframework.stereotype.Service

@Service
class AutotaxiService {

    val planes = mutableMapOf<Plane, TaxiNode?>()

    fun addPlane(plane: Plane, route: TaxiNode?) {
        planes.putIfAbsent(plane, route)
    }

    fun runTaxiLoop() {
        planes.map { it.toPair() }.forEach {
            taxiPlane(it)
        }
    }

    fun taxiPlane(planeRoute: Pair<Plane, TaxiNode?>) {
        val plane = planeRoute.first
        val route = planeRoute.second

        if (route?.next === null) return

        when (route.turn) {
            "left" -> TODO()
            "right" -> TODO()
            else -> TODO()
        }
        Thread.sleep(1500)
        println("${plane.callsign.toUpperCase()}, Taxiing on $route")

        taxiPlane(Pair(plane, route.next))
    }
}