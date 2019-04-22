/*
========================================================================
SchemaCrawler
http://www.schemacrawler.com
Copyright (c) 2000-2019, Sualeh Fatehi <sualeh@hotmail.com>.
All rights reserved.
------------------------------------------------------------------------

SchemaCrawler is distributed in the hope that it will be useful, but
WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.

SchemaCrawler and the accompanying materials are made available under
the terms of the Eclipse Public License v1.0, GNU General Public License
v3 or GNU Lesser General Public License v3.

You may elect to redistribute this code under any of these licenses.

The Eclipse Public License is available at:
http://www.eclipse.org/legal/epl-v10.html

The GNU General Public License v3 and the GNU Lesser General Public
License v3 are available at:
http://www.gnu.org/licenses/

========================================================================
*/

package schemacrawler.tools.commandline.command;


import static us.fatehi.commandlineparser.CommandLineUtility.applyApplicationLogLevel;

import java.util.logging.Level;

import picocli.CommandLine;
import schemacrawler.tools.commandline.LogLevel;

@CommandLine.Command(name = "log", description = "Turns logging on or off, and sets log level")
public final class LogCommand
  implements Runnable
{

  @CommandLine.Option(names = {
    "--log-level" }, description = "Set logging level")
  private LogLevel loglevel;

  @Override
  public void run()
  {
    final Level level = getLogLevel().getLevel();
    applyApplicationLogLevel(level);
  }

  public LogLevel getLogLevel()
  {
    if (loglevel == null)
    {
      loglevel = LogLevel.OFF;
    }
    return loglevel;
  }

}
