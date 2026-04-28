//> using scala "3.8.3"
//> using file ./smart-traffic-simulator-backend/src/main/scala/simulator/SimulationEngine.scala

import simulator.SimulationEngine

val result = SimulationEngine.run(args(0), args(1))
println(result)