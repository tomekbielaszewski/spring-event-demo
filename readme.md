# Spring eventing system demo

Graph for synchronous and async event listeners looks the same

![event-flow-graph](./src/main/resources/event-flow.png)

```
Output:

[           main] pl.grizwold.SpringEventDemoApplication   : Publishing event...
[           main] pl.grizwold.listeners.EventListener      : Processing FooEvent(payload=Kaboom!!)
[           main] pl.grizwold.listeners.FooEventListener   : Processing FooEvent(payload=Kaboom!!)
[           main] pl.grizwold.listeners.FooEventListener   : Raising BarEvent(payload=Kaboom!!)
[           main] pl.grizwold.listeners.BarEventListener   : Processing BarEvent(payload=Kaboom!!)
[           main] pl.grizwold.listeners.BarEventListener   : Raising [TarEvent(payload=Kaboom!!), ZarEvent(payload=Kaboom!!)]
[           main] pl.grizwold.listeners.EventListener      : Processing TarEvent(payload=Kaboom!!)
[           main] pl.grizwold.listeners.TarEventListener   : Processing TarEvent(payload=Kaboom!!)
[           main] pl.grizwold.listeners.TarEventListener   : Raising ZarEvent(payload=Kaboom!!)
[           main] pl.grizwold.listeners.EventListener      : Processing ZarEvent(payload=Kaboom!!)
[           main] pl.grizwold.listeners.ZarEventListener   : Processing ZarEvent(payload=Kaboom!!)
[           main] pl.grizwold.listeners.EventListener      : Processing ZarEvent(payload=Kaboom!!)
[           main] pl.grizwold.listeners.ZarEventListener   : Processing ZarEvent(payload=Kaboom!!)
[           main] pl.grizwold.listeners.EventListener      : Processing BarEvent(payload=Kaboom!!)
```

```
Output for async listeners with FixedThreadPool(4) executor:

[           main] pl.grizwold.SpringEventDemoApplication   : Publishing async event...
[pool-1-thread-2] p.g.a.listeners.AnotherFooEventListener  : Processing AnotherFooEvent(payload=Kaboom!!)
[pool-1-thread-2] p.g.a.listeners.AnotherFooEventListener  : Raising AnotherBarEvent(payload=Kaboom!!)
[pool-1-thread-1] p.g.a.listeners.AnotherEventListener     : Processing AnotherFooEvent(payload=Kaboom!!)
[pool-1-thread-3] p.g.a.listeners.AnotherBarEventListener  : Processing AnotherBarEvent(payload=Kaboom!!)
[pool-1-thread-3] p.g.a.listeners.AnotherBarEventListener  : Raising [AnotherTarEvent(payload=Kaboom!!), AnotherZarEvent(payload=Kaboom!!)]
[pool-1-thread-2] p.g.a.listeners.AnotherEventListener     : Processing AnotherTarEvent(payload=Kaboom!!)
[pool-1-thread-1] p.g.a.listeners.AnotherTarEventListener  : Processing AnotherTarEvent(payload=Kaboom!!)
[pool-1-thread-1] p.g.a.listeners.AnotherTarEventListener  : Raising AnotherZarEvent(payload=Kaboom!!)
[pool-1-thread-1] p.g.a.listeners.AnotherEventListener     : Processing AnotherZarEvent(payload=Kaboom!!)
[pool-1-thread-1] p.g.a.listeners.AnotherZarEventListener  : Processing AnotherZarEvent(payload=Kaboom!!)
[pool-1-thread-1] p.g.a.listeners.AnotherEventListener     : Processing AnotherZarEvent(payload=Kaboom!!)
[pool-1-thread-2] p.g.a.listeners.AnotherZarEventListener  : Processing AnotherZarEvent(payload=Kaboom!!)
[pool-1-thread-4] p.g.a.listeners.AnotherEventListener     : Processing AnotherBarEvent(payload=Kaboom!!)
```