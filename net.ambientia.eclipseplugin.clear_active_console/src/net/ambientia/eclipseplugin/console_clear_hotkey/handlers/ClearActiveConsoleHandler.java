package net.ambientia.eclipseplugin.console_clear_hotkey.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.console.IConsoleView;
import org.eclipse.ui.console.TextConsole;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * Clears the active console
 * 
 * @author jaakkol
 */
public class ClearActiveConsoleHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		IConsoleView consoleView = getConsoleView(window);
		if (consoleView != null) {
			IConsole activeConsole = consoleView.getConsole();
			if (activeConsole != null && activeConsole instanceof TextConsole) {
				TextConsole textConsole = (TextConsole)activeConsole;
				textConsole.clearConsole();
			}
		}
		
		return null;
	}
	
	private IConsoleView getConsoleView(IWorkbenchWindow window) {
		IWorkbenchPage workbenchPage = window.getActivePage();
		return (IConsoleView)workbenchPage.findView(IConsoleConstants.ID_CONSOLE_VIEW);
	}
}
