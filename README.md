Renate
======

Old barely implemented custom Minecraft server, last change dated 2012-07-29 (git author date faked to reflect that)

Renate - German/Duth/Norwegian form of Renatus, meaning "Reborn"
This was a collaborative project between @ylt, @sinz and @woder.

History
-------

Back in Minecraft Classic, we ran the D3 community servers, custom server software written by Dadido3 in PureBasic (Basic-like procedural programming language). While it was great, it had the limitations due to the simple nature of it's procedural design (fairly clunky).

The aim of the project was to give the amount of control that D3 server allowed for Minecraft Classic for the then new "SMP", the more complex nature meant that an object orientated design was needed. The server mods do add scripting support, but in doing things, felt that we were always wrestling against the design of the regular server. So the aim of Renate was to be a clean implementation with a huge amount of hooks and flexibility in usage.

Some parts of this were over engineered, the Java IO library is fairly outdated and the NIO was a pain to use so we actually ended up writing a basic library on top of NIO (co.d3s.ylt.renate.network) which was designed to be capable of accepting any unpredictable stream without having to use blocking reads, semi-state machine based logic was used for this. But have had many problems with it due to NIO, and the abstraction itself causing problems so in a few places have actually done temporary hacks out of laziness (directly calling back into server code, if I remember correctly for detecting disconnects).

The protocol and generic clases for mobs was about the most ever implemented, world loading was never done, was missing pings, etc.

Future Plans (of the time)
----------------------------

One of the main ideas in mind were to make it a clustered server so that it had no main node. In order to implement, the plan was to make the server actually consist of many smaller servers held together by a proxy (or a modded game). World chunks would be synchronised on disk between all servers (or maybe not if using a form of version control, didn't fully plan). Servers would load groups of chunks (aiming for a single large block), if chunks are touching, duplicate the chunk on both server nodes (allow mob path finding to work). Would make the servers broadcast chat to all the other servers.

The proxy would connect to a selection of servers (specified in DNS), the server would respond stating player info (synchronised throughout pool), the proxy would then look up the chunk info for player coordinate which would then return a world server to connect to. As player moves about they will end up transitioning between many different map servers. We also had plans for Bukkit plugins planned, they would have been implemented as a single server which connects to the pool (obviously great latency and risk of that node crashing).

Other things was to actually optimise the sending to reduce lag of network, players and to reduce xray hackers. If the player is on the surface, do we really need to send the caves below? or the different block types consisting of the ground? Of course not! The aim was to only send stuff within the players current "bubble", and just fill the rest in with either stone or air.

This then lead onto another idea, if we could really optimise the sending enough for it to be quick - then it would be easy to implement infinite height worlds by physically resending world at different positions and teleporting player to match. We'd store lightmaps for each X,Z and X,Y,Z chunk - both of which would benefit each other. X,Y,Z would allow easily looking up the coords without having to scan unloaded blocks. And X,Y,Z would allow looking up the X,Z total height value. Would it have worked? if it did, would it be fast? no idea..

Now
---

Development of the server was stopped due to massively losing motivation, it was a pain to keep up with Minecraft updates and because of the nature of the bugs, the fixes involved manual refactoring throughout every protocol message.


Make what you will of the code, I was tempted to license it under WTFPL (http://www.wtfpl.net/about/) but it's apparently discouraged legally so I've decided to license it under Public Domain

License
-------

This is free and unencumbered software released into the public domain.

Anyone is free to copy, modify, publish, use, compile, sell, or
distribute this software, either in source code form or as a compiled
binary, for any purpose, commercial or non-commercial, and by any
means.

In jurisdictions that recognize copyright laws, the author or authors
of this software dedicate any and all copyright interest in the
software to the public domain. We make this dedication for the benefit
of the public at large and to the detriment of our heirs and
successors. We intend this dedication to be an overt act of
relinquishment in perpetuity of all present and future rights to this
software under copyright law.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
OTHER DEALINGS IN THE SOFTWARE.

For more information, please refer to [http://unlicense.org]
